package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:GoodsController
 *@author:wsn
 *date:2021/7/6 14:30
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.service.GoodsService;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@Api(tags = "商品接口")
public class GoodsController {


    @Autowired
    GoodsService goodsService;

    @GetMapping("/allGoods")
    @ApiOperation(value = "所有商品",notes = "获得所有商品的所有信息")
    public Map<String,Object> getAllGoods(){
        return goodsService.getAllGoods();
    }


    @PostMapping("/addCollect")
    @ApiOperation(value = "收藏增加",notes = "收藏加1")
    public Map<String,Object> addCollect(int good_id){
        return goodsService.addCollect(good_id);
    }
    @PostMapping("/addSell")
    @ApiOperation(value = "销量增加",notes = "增加销量,传入购买商品和数量的数组")
    public Map<String,Object> addSell(int []good_id,int []num){
        return goodsService.addSell(good_id,num);
    }

    @PostMapping("/goodById")
    @ApiOperation(value = "根据id获得商品",notes = "根据id获得商品")
    public Map<String,Object>getGoodById(int good_id){
        return goodsService.getGoodById(good_id);
    }
    @PostMapping("/stockPrice")
    @ApiOperation(value = "获得具体id，库存和价格",notes = "根据不同特征获得具体id，商品库存和价格")
    public Map<String,Object> getStockPrice(int good_id,int []specs){
        return goodsService.getStockPrice(good_id,specs);

    }
    @PostMapping("/goodTest")
    @ApiOperation(value = "商品详细分类",notes = "根据id获得商品详细分类")
    public Map<String,Object> getGoodTypes(int good_id){
        return goodsService.getGoodTypes(good_id);
    }

    @PostMapping("/detailMsg")
    @ApiOperation(value = "特征详细信息",notes = "通过详细分类的id获得详细信息")
    public Map<String,Object> getSpecsDesc(int id){
        return goodsService.getSpecsDesc(id);
    }

    @PostMapping("/categoryGoods")
    @ApiOperation(value = "获得各分类下的商品",notes = "根据分类id获得商品")
    public Map<String,Object> getGoodsByType(int category_id){
        return goodsService.getGoodsByType(category_id);
    }
}