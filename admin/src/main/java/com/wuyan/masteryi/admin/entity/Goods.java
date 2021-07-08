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
}
