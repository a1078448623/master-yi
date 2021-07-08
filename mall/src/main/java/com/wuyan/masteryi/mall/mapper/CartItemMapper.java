package com.wuyan.masteryi.mall.mapper;

import com.wuyan.masteryi.mall.entity.SingleCartItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:40
 * @Description:
 */

@Repository
@Mapper
public interface CartItemMapper {
    int addCartItem(Integer userId, Integer goodsId, Integer goodsNum);//这里的goods_id其实指的是specs_id。
    int deleteCartItemById(Integer cartItemId);
    int deleteAllCartItem(Integer userId);
    int changeGoodsNumById(Integer cartItemId, Integer newGoodsNum);
    int goodsNumSub1(Integer cartItemId);
    int goodsNumAdd1(Integer cartItemId);
    List<SingleCartItem> showMyCart(Integer userId);
}
