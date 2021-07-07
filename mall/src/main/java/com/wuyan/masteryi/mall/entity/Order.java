package com.wuyan.masteryi.mall.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

import java.util.Date;

@Data
public class Order {
    private Integer orderId;
    private Integer UserId;
    private float orderTotalPrice;
    private Integer orderStatus;
    private Date createTime;
    private String orderAddr;
    private String orderNo;
    private String formate_time;

    public Order(Integer orderId, Integer userId, float orderTotalPrice, Integer orderStatus, Date createTime, String orderAddr, String orderNo) {
        this.orderId = orderId;
        UserId = userId;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.orderAddr = orderAddr;
        this.orderNo = orderNo;
    }

    public Order(Integer orderId, Integer userId, float orderTotalPrice, Integer orderStatus, Date createTime, String orderAddr, String orderNo, String formate_time) {
        this.orderId = orderId;
        UserId = userId;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.orderAddr = orderAddr;
        this.orderNo = orderNo;
        this.formate_time = formate_time;
    }
}
