package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:OrderServiceImpl
 *@author:wsn
 *date:2021/7/6 15:50
 */

import com.wuyan.masteryi.mall.entity.Order;
import com.wuyan.masteryi.mall.mapper.OrderMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemService orderItemService;
    @Override
    public Map<String, Object> getOrdersByUID(int u_id) {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm;ss");
        List<Order> res=orderMapper.getOrdersByUID(u_id);
        if(res==null) return ResponseMsg.sendMsg(100,"该用户没有订单",null);
        else {
            for(Order o :res){
                o.setFormate_time(sdf.format(o.getCreateTime()));
            }
            return ResponseMsg.sendMsg(200, "查询成功", res);
        }
    }

    @Override
    public Map<String, Object> getOrdersById(int order_id) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm;ss");
        Order order=orderMapper.getOrdersById(order_id);
        if(order==null) return ResponseMsg.sendMsg(100,"查询失败",null);
        else {
            order.setFormate_time(sdf.format(order.getCreateTime()));
            return ResponseMsg.sendMsg(200, "查询成功", order);
        }
    }

    @Override
    public Map<String, Object> getOrderStatu(int order_id) {
        return ResponseMsg.sendMsg(200,"查询成功",orderMapper.getOrderStatu(order_id));

    }

    @Override
    public Map<String, Object> creatOrder(int[] goods,int[]num, int u_id, int status, float price, String address, String orderNo) {
        Order o=new Order(1,u_id,price,status,new Date(),address,orderNo,"1");
        int ii=orderMapper.creatOrder(o);
        for(int i=0;i<goods.length;i++){
            orderItemService.addItem(o.getOrderId(),goods[i],num[i]);
        }
        return ResponseMsg.sendMsg(200,"创建成功",true);
    }
}
