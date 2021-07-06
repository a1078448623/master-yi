package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.service.CartItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:40
 * @Description:
 */

@Api("cartitem")
@RestController
@RequestMapping("/cartitem")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @ApiOperation(value="添加商品到购物车", notes="添加商品到购物车")
    @PostMapping("/addcartitem")
    public Map<String,Object> addCartItem(Integer userId, Integer goodsId, Integer goodsNum){
        return cartItemService.addCartItem(userId, goodsId, goodsNum);
    }

    @ApiOperation(value="删除购物车勾选项", notes="删除购物车勾选项")
    @PostMapping("/deletecartitembyid")
    public Map<String,Object> deleteCartItemById(Integer[] selectedCartItemId){
        return cartItemService.deleteCartItemById(selectedCartItemId);
    }

    @ApiOperation(value="删除购物车中全部项", notes="删除购物车中全部项")
    @PostMapping("/deleteallcartitem")
    public Map<String,Object> deleteAllCartItem(Integer userId){
        return cartItemService.deleteAllCartItem(userId);
    }

    @ApiOperation(value="更改加购数量", notes="更改加购数量")
    @PostMapping("/changegoodsnumbyid")
    public Map<String,Object> changeGoodsNumById(Integer cartItemId, Integer newGoodsNum){
        return cartItemService.changeGoodsNumById(cartItemId, newGoodsNum);
    }

}