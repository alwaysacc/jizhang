package com.jizhang.jizhang.controller;
import com.alibaba.fastjson.JSONObject;
import com.jizhang.jizhang.utils.Result;
import com.jizhang.jizhang.utils.ResultGenerator;
import com.jizhang.jizhang.model.Suggest;
import com.jizhang.jizhang.service.SuggestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jizhang.jizhang.utils.UUIDS;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by alwaysacc on 2019/03/13.
*/
@RestController
@RequestMapping("/suggest")
public class SuggestController {
    @Resource
    private SuggestService suggestService;

    @PostMapping("/add")
    public Result add(String suggest) {
        Suggest s= JSONObject.parseObject(suggest,Suggest.class);
        s.setCreatetime(UUIDS.getDateTime());
        suggestService.save(s);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        suggestService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Suggest suggest) {
        suggestService.update(suggest);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Suggest suggest = suggestService.findById(id);
        return ResultGenerator.genSuccessResult(suggest);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Suggest> list = suggestService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
