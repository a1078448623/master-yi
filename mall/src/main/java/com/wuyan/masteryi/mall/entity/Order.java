package com.wuyan.masteryi.mall.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

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
