package com.jizhang.jizhang.service;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.utils.Service;


/**
 * Created by alwaysacc on 2019/03/08.
 */
public interface WxUserService extends Service<WxUser> {

    WxUser getUser(String openId);

}
