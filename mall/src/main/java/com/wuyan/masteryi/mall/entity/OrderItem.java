package com.wuyan.masteryi.mall.entity;

import lombok.Data;

@Data
public class OrderItem {
    private Integer orderItemId;
    private Integer orderId;
    private Integer goodsId;
    private Integer goodsNum;
}
