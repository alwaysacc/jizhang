package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.WxUserMapper;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.service.WxUserService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by alwaysacc on 2019/03/08.
 */
@Service
@Transactional
public class WxUserServiceImpl extends AbstractService<WxUser> implements WxUserService {
    @Resource
    private WxUserMapper wxUserMapper;

    public WxUser getUser(String openId){
       return wxUserMapper.getUser(openId);
    }
}
