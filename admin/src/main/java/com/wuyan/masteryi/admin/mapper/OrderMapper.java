package com.wuyan.masteryi.admin.mapper;

import com.wuyan.masteryi.admin.entity.Order;
import com.wuyan.masteryi.admin.entity.OrderItem;
import com.wuyan.masteryi.admin.entity.SingleOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/8 14:42
 * @Description:
 */

@Mapper
@Repository
public interface OrderMapper {
    List<Order> getAllOrder();
    List<Order> getOneUserOrder(Integer userId);
    List<SingleOrderItem> getOrderItem(int orderId);
    //List<OrderItem> getOrderItem(Integer orderId);
    int agreeRefund(Integer orderId);
    int disagreeRefund(Integer orderId);
    int delOrder(int orderId);
    Order getOrderById(int orderId);
}
