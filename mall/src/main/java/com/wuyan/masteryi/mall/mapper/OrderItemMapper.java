package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:OrderItemMapper
 *@author:wsn
 *date:2021/7/6 16:48
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.entity.OrderItem;
import com.wuyan.masteryi.mall.entity.SingleOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderItemMapper {

    List<SingleOrderItem> getOrderGoods(int order_id);
    List<OrderItem> getItems(int order_id);
    List<OrderItem> getItemsByNo(String orderNo);
    int addItem(int order_id,int good_id,int num,float price);
    int delOrderItem(int order_id);
}
