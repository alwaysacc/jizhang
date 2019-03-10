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
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 代码生成器 on 2019/03/07.
*/
@RestController
@RequestMapping("/income")
public class IncomeOutlayController {
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
    public Result update(IncomeOutlay incomeOutlay) {
        incomeOutlayService.update(incomeOutlay);
        return ResultGenerator.genSuccessResult();
    }
    
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        IncomeOutlay incomeOutlay = incomeOutlayService.findById(id);
        return ResultGenerator.genSuccessResult(incomeOutlay);
    }
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam String userid) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(IncomeOutlay.class);
        condition.createCriteria().andCondition("userId ="+"'"+userid+"'");
        List<IncomeOutlay> list = incomeOutlayService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(ResultGenerator.genSuccessResult(pageInfo));
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    //获取天，周，月，年
    @PostMapping("/getListByUserid")
    public Result getListByUserid(@RequestParam String userid,String by) {
        List list = null;
        switch (by){
            case "天":
                list=incomeOutlayService.getToday(userid);
                break;
            case "周":
                list=incomeOutlayService.getWeek(userid);
                break;
            case "月":
                list=incomeOutlayService.getMonth(userid);
                break;
            case "年":
                list=incomeOutlayService.getYear(userid);
        }
        return ResultGenerator.genSuccessResult(list);
    }


}
