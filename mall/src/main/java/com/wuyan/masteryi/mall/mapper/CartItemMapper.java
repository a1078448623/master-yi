package com.wuyan.masteryi.mall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:40
 * @Description:
 */

@Repository
@Mapper
public interface CartItemMapper {
    int addCartItem(Integer userId, Integer goodsId, Integer goodsNum);
    int deleteCartItemById(Integer cartItemId);
    int deleteAllCartItem(Integer userId);
    int changeGoodsNumById(Integer cartItemId, Integer newGoodsNum);
    int goodsNumSub1(Integer cartItemId);
    int goodsNumAdd1(Integer cartItemId);

}
