package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.service.GoodsService;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(tags="商品管理接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation(value="获取全部商品", notes="获取全部商品")
    @PostMapping("/getallgoods")
    public Map<String, Object> getAllGoods(){ return goodsService.getAllGoods();}

    @ApiOperation(value="获取该商品全部属性", notes="获取该商品全部属性")
    @PostMapping("/getallgoodspecs")
    public Map<String, Object> getAllSpecs(Integer goods_id) {
        return goodsService.getAllSpecs(goods_id);
    }

    @ApiOperation(value="添加商品", notes="添加商品")
    @PostMapping("/addgood")
    public Map<String, Object> addGood(String goodsName, String goodsInformation, Integer goodsCategoryId,
                                       String goodsCoverUrl, Integer collectNum, Integer sellNum) {
        return goodsService.addGood(goodsName, goodsInformation, goodsCategoryId, goodsCoverUrl, collectNum, sellNum);
    }

    @ApiOperation(value="添加商品属性", notes="添加商品属性")
    @PostMapping("/addspec")
    public Map<String, Object> addSpecs(Integer goodsId, String specs, Integer stock, float price) {
        return goodsService.addSpecs(goodsId, specs, stock, price);
    }

    @ApiOperation(value="改变商品库存", notes="改变商品库存")
    @PostMapping("/changstock")
    public Map<String, Object> changeStock(Integer newStock, Integer goodSpecsId) {
        return goodsService.changeStock(newStock, goodSpecsId);
    }

    @ApiOperation(value="改变商品价格", notes="改变商品价格")
    @PostMapping("/changeprice")
    public Map<String, Object> changePrice(Integer newPrice, Integer goodSpecsId) {
        return goodsService.changePrice(newPrice, goodSpecsId);
    }

    @ApiOperation(value="删除商品属性", notes="删除商品属性")
    @PostMapping("/deletespecs")
    public Map<String, Object> deleteSpecs(Integer goodSpecsId) {
        return goodsService.deleteSpecs(goodSpecsId);
    }

    @ApiOperation(value="删除商品", notes="删除商品")
    @PostMapping("/deleteGoods")
    public Map<String, Object> deleteGoods(Integer goodsId) {
        return goodsService.deleteGoods(goodsId);
    }

}
