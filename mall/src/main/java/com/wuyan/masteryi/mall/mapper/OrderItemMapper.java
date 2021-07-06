package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:OrderItemMapper
 *@author:wsn
 *date:2021/7/6 16:48
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderItemMapper {

    List<Goods> getOrderGoods(int order_id);
    List<OrderItem> getItems(int order_id);
    int addItem(int order_id,int good_id,int num);
}
