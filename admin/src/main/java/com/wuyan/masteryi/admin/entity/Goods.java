package com.wuyan.masteryi.admin.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

@Data
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsInformation;
    private Integer goodsCategoryId;
    private String goodsCoverUrl;
    private Integer collectNum;
    private Integer sellNum;
    private float lowPrice;

    public Goods(Integer goodsId, String goodsName, String goodsInformation, Integer goodsCategoryId, String goodsCoverUrl, Integer collectNum, Integer sellNum) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsInformation = goodsInformation;
        this.goodsCategoryId = goodsCategoryId;
        this.goodsCoverUrl = goodsCoverUrl;
        this.collectNum = collectNum;
        this.sellNum = sellNum;
    }

    public Goods(Integer goodsId, String goodsName, String goodsInformation, Integer goodsCategoryId, String goodsCoverUrl, Integer collectNum, Integer sellNum, float lowPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsInformation = goodsInformation;
        this.goodsCategoryId = goodsCategoryId;
        this.goodsCoverUrl = goodsCoverUrl;
        this.collectNum = collectNum;
        this.sellNum = sellNum;
        this.lowPrice = lowPrice;
    }
}
