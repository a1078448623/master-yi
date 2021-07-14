package com.wuyan.masteryi.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SkGoods {
    private String goodsId;
    private String goodsName;
    private String goodsCoverUrl;
    private int stock;
    private float newprice;
    private float oldprice;
    private Date bDate;
    private Date eDate;
}
