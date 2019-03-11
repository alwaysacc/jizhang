package com.jizhang.jizhang.dao;

import com.jizhang.jizhang.model.Account;
import com.jizhang.jizhang.utils.Mapper;

public interface AccountMapper extends Mapper<Account> {
    Account getAccount(String userid);
}
