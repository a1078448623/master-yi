package com.wuyan.masteryi.mall.entity;

import lombok.Data;
import java.util.Date;

@Data
public class CartItem {
    private Integer cartItemId;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsNum;
    private Date addTime;
}