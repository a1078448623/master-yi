package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:Test
 *@author:wsn
 *date:2021/7/6 12:33
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="测试")
public class Test {

    @Autowired
    GoodsMapper goodsMapper;
    @GetMapping("/swaggerDemo")
    @ApiOperation(value = "演示",notes = "swigger演示")
    public String hello(){
        return "hello world";
    }

    @ApiOperation(value = "获取商品",notes = "获取所有商品")
    @GetMapping("/getgoods")
    public List<Goods> getGoods(){
        return goodsMapper.getAllGoods();
    }
}
