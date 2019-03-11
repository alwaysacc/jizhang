package com.jizhang.jizhang.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jizhang.jizhang.utils.Result;
import com.jizhang.jizhang.utils.ResultGenerator;
import com.jizhang.jizhang.model.Account;
import com.jizhang.jizhang.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Created by alwaysacc on 2019/03/11.
*/
@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/add")
    public Result add(Account account) {
        accountService.save(account);
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        accountService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestParam String userid,String column, @RequestParam BigDecimal num) {
        Account account = new Account();
        String reg = "[^\u4e00-\u9fa5]";
        //提取中文汉字
        column=column.replaceAll(reg, "");
        account.setUserid(userid);
        switch (column){
            case "现金":
                account.setMoney(num);
                break;
            case "银行卡":
                account.setBank(num);
                break;
            case "信用卡":
                account.setCredit(num);
                break;
            case "支付宝":
                account.setAlipay(num);
                break;
            case "微信钱包":
                account.setWechat(num);
                break;
            case "花呗":
                account.setHuabei(num);
                break;
            case "京东白条":
                account.setJingdong(num);
                break;
            case "其它":
                account.setOther(num);
                break;
        }
        accountService.update(account);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String userid) {
        Account account = accountService.getAccount(userid);
        return ResultGenerator.genSuccessResult(account);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Account> list = accountService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
