package com.jizhang.jizhang.controller;
import com.alibaba.fastjson.JSONObject;
import com.jizhang.jizhang.utils.*;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.service.IncomeOutlayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
* Created by alwaysacc on 2019/03/07.
*/
@RestController
@RequestMapping("/income")
public class IncomeOutlayController {
    private final Logger log = LoggerFactory.getLogger(IncomeOutlayController.class);
    @Resource
    private IncomeOutlayService incomeOutlayService;
    @Autowired
    private JavaMailSender jms;
    @Autowired
    private SolrUtils solrUtils;
    @PostMapping("/add")
    public Result add(String incomeOutlay){
        //JSONObject jsonObject=JSONObject.fromObject(incomeOutlay);
        //Object o=jsonObject.get(0);
        //System.out.println(jsonObject);
        IncomeOutlay income= JSONObject.parseObject(incomeOutlay,IncomeOutlay.class);
        income.setCreatedate(UUIDS.getDateTime());
        incomeOutlayService.save(income);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        incomeOutlayService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(String incomeOutlay) {
        System.out.println(incomeOutlay);
        IncomeOutlay income= JSONObject.parseObject(incomeOutlay,IncomeOutlay.class);
        incomeOutlayService.update(income);

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        IncomeOutlay incomeOutlay = incomeOutlayService.findById(id);
        return ResultGenerator.genSuccessResult(incomeOutlay);
    }
    //首页
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam String userid) {
        PageHelper.startPage(page, size);
        List<IncomeOutlay> list = incomeOutlayService.getToday(userid);
        PageInfo pageInfo = new PageInfo(list);
        int income = 0;
        int outlay = 0;
        income =incomeOutlayService.getTodayIncome(userid,1)+incomeOutlayService.getTodayIncome(userid,3);
        outlay=incomeOutlayService.getTodayIncome(userid,2);
        List l=new ArrayList();
        Map map = new HashMap();
        map.put("list",pageInfo);
        map.put("income",income);
        map.put("outlay",outlay);
        return ResultGenerator.genSuccessResult(map);
    }
    //获取天，周，月，年
    @PostMapping("/getListByUserid")
    public Result getListByUserid(@RequestParam String userid,String by,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List list = null;
        int income = 0;
        int outlay = 0;
        switch (by){
            case "天":
                list=incomeOutlayService.getToday(userid);
                income =incomeOutlayService.getTodayIncome(userid,1)+incomeOutlayService.getTodayIncome(userid,3);
                outlay=incomeOutlayService.getTodayIncome(userid,2);
                break;
            case "周":
                list=incomeOutlayService.getWeek(userid);
                income =incomeOutlayService.getWeekIncome(userid,1)+incomeOutlayService.getWeekIncome(userid,3);
                outlay=incomeOutlayService.getWeekIncome(userid,2);
                break;
            case "月":
                list=incomeOutlayService.getMonth(userid);
                income =incomeOutlayService.getMonthIncome(userid,1)+incomeOutlayService.getMonthIncome(userid,3);
                outlay=incomeOutlayService.getMonthIncome(userid,2);
                break;
            case "年":
                list=incomeOutlayService.getYear(userid);
                income =incomeOutlayService.getYearIncome(userid,1)+incomeOutlayService.getYearIncome(userid,3);
                outlay=incomeOutlayService.getYearIncome(userid,2);
        }
        PageInfo pageInfo = new PageInfo(list);
        Map map = new HashMap();
        map.put("list",pageInfo);
        map.put("income",income);
        map.put("outlay",outlay);
        return ResultGenerator.genSuccessResult(map);
    }
    @PostMapping("/sendEmail")
    public Result sendEmail(@RequestParam String email,@RequestParam String userid,@RequestParam int mouth){
        String path=System.getProperty("user.dir")+"\\";
        System.out.println(path);
        MimeMessage mMessage=jms.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        List<Map> list = incomeOutlayService.getListByMouth(userid,mouth);
        ExportExcelUtil eeu=new ExportExcelUtil();
        //excel标题
        String[] title = {"id","金额","类别","地址","备注","时间","类型","账户"};
        String[] column1 = "id,amount,category,address,remarks,caeatedate,type,account".split(",");
        //excel文件名
        String fileName = mouth+"月账单";
        //sheet名
        eeu.getOutputFile(title, column1, list, fileName,path);
        String from;
        try{
            //从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/mail.properties"));
            from = prop.get("mail.smtp.username")+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo(email);//收件人邮箱
            mMessageHelper.setSubject("用户验证码");//邮件的主题
            mMessageHelper.setText("<p>您的"+mouth+"月账单，见附件</p>",true);
            String filepath=path+fileName+".xls";
            File file=new File(filepath);//在邮件中添加一张图片
            System.out.println(filepath);
            FileSystemResource resource=new FileSystemResource(file);
            mMessageHelper.addAttachment(fileName+".xls", resource);//在邮件中添加一个附件
            jms.send(mMessage);//发送邮件
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/getCount")
    public Result getCount(@RequestParam String userid){
        List<Map> list=incomeOutlayService.getCountDay(userid);
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/select")
    public Result getCount(@RequestParam String q, @RequestParam String userid,@RequestParam Integer page, @RequestParam Integer size)  {
        Map map = null;
        try {
           map=solrUtils.select(q,page, size,userid);
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        return ResultGenerator.genSuccessResult(map);
    }
}
