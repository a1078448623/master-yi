package com.wuyan.masteryi.mall.mapper;

import com.wuyan.masteryi.mall.entity.SkGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface SkGoodsMapper {
    float getPrice(String goodsId);
    List<SkGoods> getAllSk();
}
