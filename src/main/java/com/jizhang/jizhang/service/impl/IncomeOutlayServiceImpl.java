package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.IncomeOutlayMapper;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.service.IncomeOutlayService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 代码生成器 on 2019/03/07.
 */
@Service
@Transactional
public class IncomeOutlayServiceImpl extends AbstractService<IncomeOutlay> implements IncomeOutlayService {
    @Resource
    private IncomeOutlayMapper incomeOutlayMapper;

    @Override
    public List<IncomeOutlay> getToday(String userid) {
        return incomeOutlayMapper.getToday(userid);
    }

    @Override
    public List<IncomeOutlay> getWeek(String userid) {
        return incomeOutlayMapper.getWeek(userid);
    }

    @Override
    public List<IncomeOutlay> getMonth(String userid) {
        return incomeOutlayMapper.getMonth(userid);
    }

    @Override
    public List<IncomeOutlay> getYear(String userid) {
        return incomeOutlayMapper.getYear(userid);
    }
}
