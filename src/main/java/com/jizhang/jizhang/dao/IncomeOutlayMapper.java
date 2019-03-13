package com.jizhang.jizhang.dao;

import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IncomeOutlayMapper extends Mapper<IncomeOutlay> {
    List<IncomeOutlay> getToday(String userid);
    List<IncomeOutlay> getWeek(String userid);
    List<IncomeOutlay> getMonth(String userid);
    List<IncomeOutlay> getYear(String userid);
    int getTodayIncome(@Param("userid") String userid, @Param("type") int type);
    int getWeekIncome(@Param("userid")String userid,@Param("type") int type);
    int getMonthIncome(@Param("userid")String userid,@Param("type")int type);
    int getYearIncome(@Param("userid")String userid,@Param("type")int type);
    List<Map> getListByMouth(@Param("userid")String userid, @Param("mouth") int mouth);
    List<Map> getCountDay(@Param("userid") String userid);
}
