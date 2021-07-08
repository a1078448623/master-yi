package com.wuyan.masteryi.mall.entity;

import lombok.Data;

import java.lang.ref.PhantomReference;
import java.util.Date;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/8 9:41
 * @Description:
 */

@Data
public class SingleCollectItem {
    private int collectId;
    private int goodsId;
    private String goodsName;
    private String goodsCoverUrl;
    private int specsId;
    private String specs;
    private float price;
    private Date collectTime;

}
