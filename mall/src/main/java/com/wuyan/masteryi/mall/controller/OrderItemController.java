package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:OrderItemController
 *@author:wsn
 *date:2021/7/6 14:32
 */

import com.wuyan.masteryi.mall.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/orderItem")
@Api(tags = "订单项接口")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @PostMapping("/order-goods")
    @ApiOperation(value = "订单商品",notes = "根据订单id获得订单的商品")
    public Map<String,Object> getOrderGoods(int order_id){
        return orderItemService.getOrderGoods(order_id);
    }

    @PostMapping("/getItems")
    @ApiOperation(value = "获得订单项",notes = "获得该订单的所有id信息和数量")
    public Map<String,Object> getItems(int order_id){
        return orderItemService.getItems(order_id);
    }
}
