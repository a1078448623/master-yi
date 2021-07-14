package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/8 15:17
 * @Description:
 */

@RestController
@RequestMapping("/order")
@Api(tags ="订单管理接口")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/getallorder")
    @ApiOperation(value="获取全部订单信息", notes="获取全部订单信息")
    public Map<String,Object> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping("/getoneuserorder")
    @ApiOperation(value="获取某用户订单信息", notes="获取某用户订单信息")
    public Map<String,Object> getOneUserOrder(Integer userId){
        return orderService.getOneUserOrder(userId);
    }

    @PostMapping("/getorderitem")
    @ApiOperation(value="获取订单子项", notes="获取订单子项")
    public Map<String,Object> getOrderItem(Integer orderId){
        return orderService.getOrderItem(orderId);
    }

    @PostMapping("/dealrefund")
    @ApiOperation(value="处理退款订单", notes="处理退款订单")
    public Map<String,Object> dealRefund(Integer orderId, Boolean agree){
        return orderService.dealRefund(orderId, agree);
    }

    @PostMapping("/delorder")
    @ApiOperation(value = "删除某订单",notes = "删除某订单")
    public Map<String,Object> delOrder(int orderId){
        return orderService.delOrder(orderId);
    }

}
