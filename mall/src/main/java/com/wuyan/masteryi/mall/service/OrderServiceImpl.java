package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:OrderServiceImpl
 *@author:wsn
 *date:2021/7/6 15:50
 */

import com.wuyan.masteryi.mall.entity.Order;
import com.wuyan.masteryi.mall.entity.OrderItem;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.mapper.OrderItemMapper;
import com.wuyan.masteryi.mall.mapper.OrderMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderItemMapper orderItemMapper;

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
    public Map<String, Object> creatOrder(int[] goods,int[]num, float[] singlePrice,int u_id, int status,
                                          float price, String address) {
        String orderNo=orderNoGen();
        Order o=new Order(1,u_id,price,status,new Date(),address,orderNo,"1");
        int ii=orderMapper.creatOrder(o);
        stockChange(goods,num,"sub");
        for(int i=0;i<goods.length;i++){
            orderItemService.addItem(o.getOrderId(),goods[i],num[i],singlePrice[i]);

        }
        Map<String,String> res=new HashMap<>();
        res.put("orderNo",orderNo);
        res.put("order_id",String.valueOf(o.getOrderId()));
        return ResponseMsg.sendMsg(200,"创建成功",res);
    }

    @Override
    public String orderNoGen() {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhh");
        Random r=new Random();
        return sdf.format(date)+r.nextInt(900000)+100000+String.valueOf(date.getTime()).substring(5);
    }

    @Override
    public int delOrder(int order_id, String orderNo) {
        List<OrderItem> items = orderItemMapper.getItems(order_id);
        int [] ids=new int[items.size()];
        int [] nums=new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            ids[i]=items.get(i).getGoodsId();
            nums[i]=items.get(i).getGoodsNum();
        }
        stockChange(ids,nums,"add");
        orderItemService.delItem(order_id);
        orderMapper.delOrder(order_id,orderNo);

        return 0;
    }

    @Override
    public void stockChange(int[] id, int[] num,String flag) {
        if("sub".equals(flag)){
            for (int i = 0; i < id.length; i++) {
                goodsMapper.stockDesc(id[i],num[i]);
            }
        }
        else if("add".equals(flag)) {
            for (int i = 0; i < id.length; i++) {
                goodsMapper.stockAdd(id[i],num[i]);
            }
        }
    }
}
