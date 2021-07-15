package com.wuyan.masteryi.mall.entity;

import lombok.Data;

/*
 *project:master-yi
 *file:GoodSpecs
 *@author:wsn
 *date:2021/7/14 19:47
 */
@Data
public class GoodSpecs {
    private Integer id;
    private Integer goodsId;
    private String specs;
    private Integer stock;
    private float price;
}