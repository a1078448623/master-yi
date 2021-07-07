package com.wuyan.masteryi.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

@Data
public class CartItem {
    private Integer cartItemId;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsNum;
    private Date addTime;
}
