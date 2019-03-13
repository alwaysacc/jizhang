package com.jizhang.jizhang.service;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.utils.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * Created by alwaysacc on 2019/03/07.
 */
public interface IncomeOutlayService extends Service<IncomeOutlay>{
    List<IncomeOutlay> getToday(String userid);
    List<IncomeOutlay> getWeek(String userid);
    List<IncomeOutlay> getMonth(String userid);
    List<IncomeOutlay> getYear(String userid);
    int getTodayIncome(String userid,int type);
    int getWeekIncome(String userid,int type);
    int getMonthIncome(String userid,int type);
    int getYearIncome(String userid,int type);
    List<Map> getListByMouth(@Param("userid")String userid, @Param("mouth") int mouth);
    List<Map> getCountDay(@Param("userid") String userid);
}
