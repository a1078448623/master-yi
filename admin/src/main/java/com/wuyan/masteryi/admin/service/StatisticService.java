package com.wuyan.masteryi.admin.service;
/*
 *project:master-yi
 *file:StatisticService
 *@author:wsn
 *date:2021/7/11 16:23
 */

import java.util.Map;

public interface StatisticService {

    Map<String,Object> getBasicData();
    Map<String,Object> getOrderCount();
    Map<String,Object> getMonthData();
    Map<String,Object> getTopGoods();
    Map<String,Object> getUserCount();
    Map<String,Object> getCateCount();

}
