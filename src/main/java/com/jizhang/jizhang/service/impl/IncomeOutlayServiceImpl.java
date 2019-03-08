package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.IncomeOutlayMapper;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.service.IncomeOutlayService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/03/07.
 */
@Service
@Transactional
public class IncomeOutlayServiceImpl extends AbstractService<IncomeOutlay> implements IncomeOutlayService {
    @Resource
    private IncomeOutlayMapper incomeOutlayMapper;

}
