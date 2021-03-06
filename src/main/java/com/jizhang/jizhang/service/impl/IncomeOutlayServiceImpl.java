package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.IncomeOutlayMapper;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.service.IncomeOutlayService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by alwaysacc on 2019/03/07.
 */
@Service
@Transactional
public class IncomeOutlayServiceImpl extends AbstractService<IncomeOutlay> implements IncomeOutlayService {
    @Autowired
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

    @Override
    public int getTodayIncome(String userid, int type) {
        return incomeOutlayMapper.getTodayIncome(userid,type);
    }

    @Override
    public int getWeekIncome(String userid, int type) {
        return incomeOutlayMapper.getWeekIncome(userid,type);
    }

    @Override
    public int getMonthIncome(String userid, int type) {
        return incomeOutlayMapper.getMonthIncome(userid,type);
    }

    @Override
    public int getYearIncome(String userid, int type) {
        return incomeOutlayMapper.getYearIncome(userid,type);
    }

    @Override
    public List<Map> getListByMouth(String userid, int mouth) {
        return incomeOutlayMapper.getListByMouth(userid,mouth);
    }

    @Override
    public  List<Map> getCountDay(String userid) {
        return incomeOutlayMapper.getCountDay(userid);
    }
}
