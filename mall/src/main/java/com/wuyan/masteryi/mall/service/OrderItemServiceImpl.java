package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:OrderItemServiceImpl
 *@author:wsn
 *date:2021/7/6 16:43
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.entity.OrderItem;
import com.wuyan.masteryi.mall.mapper.OrderItemMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public Map<String,Object> getOrderGoods(int order_id) {
        List<Goods> goodsList=orderItemMapper.getOrderGoods(order_id);
        if(goodsList!=null) return ResponseMsg.sendMsg(200,"查询成功",goodsList);
        else return ResponseMsg.sendMsg(100,"没有商品",null);

    }

    @Override
    public Map<String,Object> getItems(int order_id) {
        List<OrderItem> orderItems=orderItemMapper.getItems(order_id);
        if(orderItems!=null) return ResponseMsg.sendMsg(200,"查询成功",orderItems);
        else return ResponseMsg.sendMsg(100,"没有信息",null);
    }

    @Override
    public void addItem(int order_id, int good_id, int num) {
        orderItemMapper.addItem(order_id,good_id,num);
    }
}
