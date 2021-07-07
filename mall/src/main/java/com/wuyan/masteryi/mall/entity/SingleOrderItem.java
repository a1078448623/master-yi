package com.wuyan.masteryi.mall.entity;

import lombok.Data;

import java.util.Map;

/*
 *project:master-yi
 *file:SingleOrderItem
 *@author:wsn
 *date:2021/7/7 16:41
 */
@Data
public class SingleOrderItem {
    private int goodsId;
    private String goodsName;
    private String goodsInformation;
    private String goodsCoverUrl;
    private int id;
    private int goodsNum;
    private float singlePrice;
    private Map<String,String> description;
}
