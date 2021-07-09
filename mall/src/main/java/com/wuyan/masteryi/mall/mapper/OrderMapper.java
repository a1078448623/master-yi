package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:OrderMapper
 *@author:wsn
 *date:2021/7/6 15:50
 */

import com.wuyan.masteryi.mall.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    List<Order> getOrdersByUID(int u_id);
    Order getOrdersById(int order_id);
    Order getOrdersByNo(String orderNo);
    int getOrderStatu(int order_id);
//    int creatOrder(int u_id,float price,int status,String address,String orderNo);
    int creatOrder(Order order);
    void delOrder(int order_id,String orderNo);
    void changeStatu(String orderNo,int statu);
}
