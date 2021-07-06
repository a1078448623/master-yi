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
    public int addCartItem(Integer userId, Integer goodsId, Integer goodsNum);
    public int deleteCartItemById(Integer cartItemId);
    public int deleteAllCartItem(Integer userId);
    public int changeGoodsNumById(Integer cartItemId, Integer newGoodsNum);
}
