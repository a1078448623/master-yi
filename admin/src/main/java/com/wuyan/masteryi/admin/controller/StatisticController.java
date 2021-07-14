package com.wuyan.masteryi.admin.controller;
/*
 *project:master-yi
 *file:StastisticController
 *@author:wsn
 *date:2021/7/11 16:19
 */

import com.wuyan.masteryi.admin.service.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/showdata")
@Api(tags = "首页统计接口")
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    @GetMapping("/basicdata")
    @ApiOperation(value = "基础数据",notes = "获得基础统计数据")
    public Map<String,Object> getBasicData(){

        return statisticService.getBasicData();
    }

    @GetMapping("/ordercount")
    @ApiOperation(value = "订单数和价钱统计",notes = "订单数和价钱统计")
    public Map<String,Object> getOrderCount(){
        return statisticService.getOrderCount();
    }

    @GetMapping("/monthdata")
    @ApiOperation(value = "每月销量与订单",notes = "每月销量与订单")
    public Map<String,Object> getMonthData(){
        return statisticService.getMonthData();
    }

    @GetMapping("/topgoods")
    @ApiOperation(value = "获得销量前10的商品",notes = "获得销量前10的商品")
    public Map<String,Object> getTopGoods(){
        return statisticService.getTopGoods();
    }

    @GetMapping("/userdata")
    @ApiOperation(value = "用户注册时间统计",notes = "用户注册时间统计")
    public Map<String,Object> getUserData(){
        return statisticService.getUserCount();
    }

    @GetMapping("/catedata")
    @ApiOperation(value = "分类数据统计",notes = "分类数据统计")
    public Map<String,Object> getCateData(){
        return statisticService.getCateCount();
    }
}
