package com.jizhang.jizhang.dao;

import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.utils.Mapper;

public interface WxUserMapper extends Mapper<WxUser> {
    public WxUser getUser(String openId);
}
