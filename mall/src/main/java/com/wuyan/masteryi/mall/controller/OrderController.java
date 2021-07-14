package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:OrderController
 *@author:wsn
 *date:2021/7/6 14:31
 */

import com.wuyan.masteryi.mall.service.GetUidServerImpl;
import com.wuyan.masteryi.mall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GetUidServerImpl getUid;

    @PostMapping("/creatOrder")
    @ApiOperation(value = "创建订单",notes = "根据所给所有商品和价格等信息创建订单")
    public Map<String,Object> creatOrder(int[] goods, int [] num,float[] singlePrice, int status,
                                         float price, String address,
                                         @CookieValue(value = "token",
                                                 defaultValue = "Atta") String token){
        return orderService.creatOrder(goods,num,singlePrice,getUid.getintUid(token),status,price,address);
    }

    @ApiOperation(value = "根据用户获取订单",notes = "根据所给的用户id来获取该用户的所有订单")
    @PostMapping("/getOrderByuid")
    public Map<String,Object>getOrdersByUID(@CookieValue(value = "token",
            defaultValue = "Atta") String token){
        return orderService.getOrdersByUID(getUid.getintUid(token));
    }

    @ApiOperation(value = "根据订单id获取订单",notes = "根据订单id获取订单")
    @PostMapping("/getOrderByid")
    public Map<String,Object> getOrdersById(int order_id){
        return orderService.getOrdersById(order_id);
    }

    @PostMapping("/getStatus")
    @ApiOperation(value = "获取订单状态",notes = "获取所给订单的订单状态")
    public Map<String,Object> getOrderStatu(int order_id){
        return orderService.getOrderStatu(order_id);

    }
}
