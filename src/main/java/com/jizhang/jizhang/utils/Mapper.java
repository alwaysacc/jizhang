package com.jizhang.jizhang.utils;

import com.jizhang.jizhang.model.IncomeOutlay;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.util.List;
import java.util.Map;

/**
 * 定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加。
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
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
