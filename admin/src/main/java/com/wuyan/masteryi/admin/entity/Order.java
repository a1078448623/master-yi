package com.wuyan.masteryi.admin.entity;

import lombok.Data;

import java.util.Date;

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
    private Date createTime;
    private String address;
    private String orderNo;
    //private String formate_time;

    public Order(Integer orderId, Integer userId, float orderTotalPrice, Integer orderStatus, Date createTime, String address, String orderNo) {
        this.orderId = orderId;
        UserId = userId;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.address = address;
        this.orderNo = orderNo;
        //this.formate_time = formate_time;
    }
}
