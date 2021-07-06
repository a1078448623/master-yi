package com.wuyan.masteryi.mall.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsInformation;
    private Integer goodsCategoryId;
    private String goodsCoverUrl;
    private float goodsPrice;
    private Integer stockNum;
    private Integer collectNum;
    private Integer sellNum;
}
