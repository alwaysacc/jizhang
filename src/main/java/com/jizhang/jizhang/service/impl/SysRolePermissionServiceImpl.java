package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.SysRolePermissionMapper;
import com.jizhang.jizhang.model.SysRolePermission;
import com.jizhang.jizhang.service.SysRolePermissionService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by alwaysacc on 2019/03/22.
 */
@Service
@Transactional
public class SysRolePermissionServiceImpl extends AbstractService<SysRolePermission> implements SysRolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

}
