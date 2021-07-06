package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:GoodsService
 *@author:wsn
 *date:2021/7/6 15:06
 */

import com.wuyan.masteryi.mall.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    Map<String,Object> getAllGoods();
    Map<String,Object> addSell(int []good_id,int []num);
    Map<String,Object> addCollect(int good_id);
    Map<String,Object> descStock(int []good_id,int []num);
    Map<String,Object> getGoodById(int good_id);
}
