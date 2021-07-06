package com.wuyan.masteryi.mall.entity;

import lombok.Data;

@Data
public class CartItem {
    private Integer cartItemId;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsNum;
}
