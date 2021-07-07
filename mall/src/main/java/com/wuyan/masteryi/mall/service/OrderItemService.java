package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:OrderItemService
 *@author:wsn
 *date:2021/7/6 16:43
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.entity.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemService {

    Map<String,Object> getOrderGoods(int order_id);
    Map<String,Object> getItems(int order_id);
    void addItem(int order_id,int good_id,int num,float price);
    void delItem(int order_id);
}
