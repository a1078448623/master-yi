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
}
