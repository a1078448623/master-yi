package com.wuyan.masteryi.mall.entity;

import lombok.Data;

import java.lang.ref.PhantomReference;
import java.util.Date;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/8 10:17
 * @Description:
 */

@Data
public class SingleCartItem {
    private int cartItemId;
    private int goodsNum;
    private int goodsId;
    private String goodsName;
    private String goodsInformation;
    private String goodsCoverUrl;
    private int id;//规格id
    private String specs;
    private float price;
    private Date addTime;
}
