package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.SysPermissionMapper;
import com.jizhang.jizhang.model.SysPermission;
import com.jizhang.jizhang.service.SysPermissionService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by alwaysacc on 2019/03/22.
 */
@Service
@Transactional
public class SysPermissionServiceImpl extends AbstractService<SysPermission> implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

}
