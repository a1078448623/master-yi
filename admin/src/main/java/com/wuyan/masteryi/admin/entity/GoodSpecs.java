package com.wuyan.masteryi.admin.entity;

import lombok.Data;

@Data
public class GoodSpecs {
    private Integer specsId;
    private Integer goodsId;
    private String specs;
    private Integer stock;
    private float price;
}
