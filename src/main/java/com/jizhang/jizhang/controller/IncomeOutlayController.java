package com.jizhang.jizhang.controller;
import com.jizhang.jizhang.utils.Result;
import com.jizhang.jizhang.utils.ResultGenerator;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.service.IncomeOutlayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

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
    public Result add(IncomeOutlay incomeOutlay) {
        incomeOutlayService.save(incomeOutlay);
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
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<IncomeOutlay> list = incomeOutlayService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(ResultGenerator.genSuccessResult(pageInfo));
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
