package com.jizhang.jizhang.controller;
import com.alibaba.fastjson.JSONObject;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.utils.Result;
import com.jizhang.jizhang.utils.ResultGenerator;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.service.IncomeOutlayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jizhang.jizhang.utils.UUIDS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by alwaysacc on 2019/03/07.
*/
@RestController
@RequestMapping("/income")
public class IncomeOutlayController {
    private final Logger log = LoggerFactory.getLogger(IncomeOutlayController.class);
    @Resource
    private IncomeOutlayService incomeOutlayService;

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


}
