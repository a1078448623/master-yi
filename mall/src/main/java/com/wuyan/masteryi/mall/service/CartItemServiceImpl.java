package com.wuyan.masteryi.mall.service;

import com.wuyan.masteryi.mall.entity.CartItem;
import com.wuyan.masteryi.mall.mapper.CartItemMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:40
 * @Description:
 */

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    public Map<String,Object> addCartItem(Integer userId, Integer goodsId, Integer goodsNum) {
        return ResponseMsg.sendMsg(200, "成功添加到购物车", cartItemMapper.addCartItem(userId, goodsId, goodsNum));
    }

    @Override
    public Map<String,Object> deleteCartItemById(Integer[] selectedCartItemId) {
        for(int CartItemId:selectedCartItemId){
            if(cartItemMapper.deleteCartItemById(CartItemId) == 0){
                return ResponseMsg.sendMsg(200, "从购物车删除时发生错误", 0);
            }
        }
        return ResponseMsg.sendMsg(200, "成功删除购物车部分项", 1);
    }

    @Override
    public Map<String,Object> deleteAllCartItem(Integer userId) {
        return ResponseMsg.sendMsg(200, "成功删除购物车所有项", cartItemMapper.deleteAllCartItem(userId));
    }

    @Override
    public Map<String,Object> changeGoodsNumById(Integer cartItemId, Integer newGoodsNum) {
        return ResponseMsg.sendMsg(200, "成功更改购物车中商品数量", cartItemMapper.changeGoodsNumById(cartItemId, newGoodsNum));
    }

    @Override
    public Map<String, Object> goodsNumSub1(Integer cartItemId) {
        return ResponseMsg.sendMsg(200, "成功将购物车商品数量减一", cartItemMapper.goodsNumSub1(cartItemId));
    }

    @Override
    public Map<String, Object> goodsNumAdd1(Integer cartItemId) {
        return ResponseMsg.sendMsg(200, "成功将购物车商品数量加一", cartItemMapper.goodsNumAdd1(cartItemId));
    }
}
