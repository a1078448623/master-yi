package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.Order;
import com.wuyan.masteryi.admin.entity.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/8 14:54
 * @Description:
 */
public interface OrderService {
    Map<String,Object> getAllOrder();
    Map<String,Object> getOneUserOrder(Integer userId);
    Map<String,Object> getOrderItem(Integer orderId);
    Map<String,Object> dealRefund(Integer orderId, Boolean agree);
}
