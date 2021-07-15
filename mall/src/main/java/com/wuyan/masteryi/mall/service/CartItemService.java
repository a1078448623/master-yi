package com.wuyan.masteryi.mall.service;

import com.wuyan.masteryi.mall.entity.SingleCartItem;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:40
 * @Description:
 */

public interface CartItemService {
    Map<String,Object> addCartItem(Integer userId, Integer goodsId, Integer goodsNum);
    Map<String,Object> deleteCartItemById(Integer[] selectedCartItemId);
    Map<String,Object> deleteAllCartItem(Integer userId);
    Map<String,Object> changeGoodsNumById(Integer cartItemId, Integer newGoodsNum);
    Map<String,Object> goodsNumSub1(Integer cartItemId);
    Map<String,Object> goodsNumAdd1(Integer cartItemId);
    Map<String,Object> showMyCart(Integer userId);
    Map<String,Object> changeCartGoodId(int cartItemId,int goodsId);
}
