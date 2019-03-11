package com.jizhang.jizhang.service;
import com.jizhang.jizhang.model.Account;
import com.jizhang.jizhang.utils.Service;


/**
 * Created by alwaysacc on 2019/03/11.
 */
public interface AccountService extends Service<Account> {
    Account getAccount(String userid);
}
