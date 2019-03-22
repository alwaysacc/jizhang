package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.SysUserMapper;
import com.jizhang.jizhang.model.SysUser;
import com.jizhang.jizhang.service.SysUserService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by alwaysacc on 2019/03/22.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

}
