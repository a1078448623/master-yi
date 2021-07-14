package com.wuyan.masteryi.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface SkGoodsMapper {
    int setSkGoods(String goodsId,String goodsName,String goodsCoverUrl,int stock, float newprice,
                   float oldprice, String bDate, String eDate);
    int deleteSkGoods(String goodsId);
}

