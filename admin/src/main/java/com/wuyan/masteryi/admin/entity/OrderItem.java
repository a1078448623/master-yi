package com.wuyan.masteryi.admin.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

@Data
public class OrderItem {
    private Integer orderItemId;
    private Integer orderId;
    private Integer goodsId;
    private Integer goodsNum;
}
