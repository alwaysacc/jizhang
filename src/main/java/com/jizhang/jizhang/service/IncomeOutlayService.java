package com.jizhang.jizhang.service;
import com.jizhang.jizhang.dao.WxUserMapper;
import com.jizhang.jizhang.model.IncomeOutlay;
import com.jizhang.jizhang.model.WxUser;
import com.jizhang.jizhang.utils.Service;

import javax.annotation.Resource;
import java.util.List;


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
}
