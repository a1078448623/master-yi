package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:OrderService
 *@author:wsn
 *date:2021/7/6 15:38
 */

import java.util.Map;

public interface OrderService {

    Map<String,Object> getOrdersByUID(int u_id);
    Map<String,Object> getOrdersById(int order_id);
    Map<String,Object> getOrderStatu(int order_id);
    Map<String,Object> creatOrder(int[] goods,int[]num,int u_id,int status,float price,String address,String orderNo);
}
