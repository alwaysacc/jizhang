package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.AccountMapper;
import com.jizhang.jizhang.model.Account;
import com.jizhang.jizhang.service.AccountService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by alwaysacc on 2019/03/11.
 */
@Service
@Transactional
public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getAccount(String userid) {
        return accountMapper.getAccount(userid);
    }
}
