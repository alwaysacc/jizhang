package com.jizhang.jizhang.dao;

import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.utils.Mapper;

import java.util.List;

public interface IncomeOutlayMapper extends Mapper<IncomeOutlay> {
    List<IncomeOutlay> getToday(String userid);
    List<IncomeOutlay> getWeek(String userid);
    List<IncomeOutlay> getMonth(String userid);
    List<IncomeOutlay> getYear(String userid);
}