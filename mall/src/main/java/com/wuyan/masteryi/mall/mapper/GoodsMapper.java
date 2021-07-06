package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:GetGoods
 *@author:wsn
 *date:2021/7/6 12:35
 */

import com.wuyan.masteryi.mall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {

    public List<Goods> getAllGoods();
}
