package com.wuyan.masteryi.admin.service;
import com.wuyan.masteryi.admin.entity.GoodSpecs;
import com.wuyan.masteryi.admin.entity.Goods;

import java.util.List;
import java.util.Map;

/*
private Integer goodsId;
    private String goodsName;
    private String goodsInformation;
    private Integer goodsCategoryId;
    private String goodsCoverUrl;
    private Integer collectNum;
    private Integer sellNum;
    private float lowPrice;
 */

public interface GoodsService {
    Map<String, Object> getAllGoods();
    Map<String, Object> getParentCategoryGoods(Integer parentId);
    Map<String, Object> getChildCategoryGoods(Integer childId);
    Map<String, Object> getAllSpecs(Integer goods_id);
    Map<String, Object> addGood(String goodsName, String goodsInformation, Integer goodsCategoryId,
                String goodsCoverUrl, Integer collectNum, Integer sellNum,int [] specs,float primaryPrice);
    Map<String, Object> addSpecs(Integer goodsId, int[] specs, Integer stock, float price);
    Map<String, Object> changeStock(Integer newStock, Integer goodSpecsId);
    Map<String, Object> changePrice(float newPrice, Integer goodSpecsId);
    Map<String, Object> deleteSpecs(Integer goodSpecsId);
    Map<String, Object> deleteGoods(Integer goodsId);
    Map<String,Object> getSpecsDesc(int id);
    Map<String,Object> getGoodTypes(int good_id);
    Map<String,Object> getValuesByKey(int []key_id);
}
