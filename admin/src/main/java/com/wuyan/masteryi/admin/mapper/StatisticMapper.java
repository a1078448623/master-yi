package com.wuyan.masteryi.admin.mapper;
/*
 *project:master-yi
 *file:StatisticMapper
 *@author:wsn
 *date:2021/7/11 16:25
 */

import com.wuyan.masteryi.admin.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StatisticMapper {

    int getUserNum();
    int getOrderNum();
    float getEraningNum();
    int getSalesNum();
    int getVisitorNum();
    List<OrderCount> getOrderCount();
    List<MonthlyData> getMonthData();
    List<Goods> getTopGoods();
    List<UserCateCount> getUserCount();
    List<UserCateCount> getCateCount();
}
