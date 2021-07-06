package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:GoodsMapper
 *@author:wsn
 *date:2021/7/6 18:30
 */

import com.wuyan.masteryi.mall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {
    List<Goods> getAllGoods();
    int addSell(int good_id, int num);
    int addCollect(int good_id);
    int descStock(int good_id, int num);
    Goods getGoodById(int good_id);
}
