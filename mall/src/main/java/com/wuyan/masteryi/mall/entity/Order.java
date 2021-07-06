package com.wuyan.masteryi.mall.entity;

import lombok.Data;

@Data
public class Order {
    private Integer orderId;
    private Integer UserId;
    private float orderTotalPrice;
    private Integer orderStatus;
    private String createTime;
    private String address;
    private String orderNo;
}
