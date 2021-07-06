package com.wuyan.masteryi.mall.service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:40
 * @Description:
 */

public interface CartItemService {
    public Map<String,Object> addCartItem(Integer userId, Integer goodsId, Integer goodsNum);
    public Map<String,Object> deleteCartItemById(Integer[] selectedCartItemId);
    public Map<String,Object> deleteAllCartItem(Integer userId);
    public Map<String,Object> changeGoodsNumById(Integer cartItemId, Integer newGoodsNum);
}
