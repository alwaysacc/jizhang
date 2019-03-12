package com.jizhang.jizhang.dao;

import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeOutlayMapper extends Mapper<IncomeOutlay> {
    List<IncomeOutlay> getToday(String userid);
    List<IncomeOutlay> getWeek(String userid);
    List<IncomeOutlay> getMonth(String userid);
    List<IncomeOutlay> getYear(String userid);
    int getTodayIncome(@Param("userid") String userid, @Param("type") int type);
    int getWeekIncome(@Param("userid")String userid,@Param("type") int type);
    int getMonthIncome(String userid,int type);
    int getYearIncome(String userid,int type);
}
