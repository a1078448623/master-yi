package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:GoodsMapper
 *@author:wsn
 *date:2021/7/6 18:30
 */

import com.wuyan.masteryi.mall.entity.GoodsAttrValue;
import com.wuyan.masteryi.mall.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GoodsMapper {
    List<Goods> getAllGoods();
    int addSell(int good_id, int num);
    int addSellByOrderId(int orderId);
    int addCollect(int good_id);
    void subCollect(int good_id);
    Goods getGoodById(int good_id);
    Map<String,Object> getStockPrice(int good_id,String specs);
    List<String> getSpecs(int good_id);
    String getKeyName(int id);
    int getKeyId(int id);
    GoodsAttrValue getValueName(int id);
    String getSpecsById(int id);
    void stockDesc(int id,int num);
    void stockAdd(int id,int num);
    List<Goods> getGoodsByType(int c_id);
    Integer getGoodIdBySpecId(Integer specId);
}
