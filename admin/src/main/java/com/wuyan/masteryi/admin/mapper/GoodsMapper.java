package com.wuyan.masteryi.admin.mapper;

import com.wuyan.masteryi.admin.entity.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GoodsMapper {
    List<Goods> getAllGoods();
    List<Integer> getChildCategoryByParentId(Integer parentId);
    List<Goods> getChildCategoryGoods(Integer childId);
    List<GoodSpecs> getAllSpecs(Integer goods_id);
    int addGood(Goods goods);
    int addSpecs(Integer goodsId, String specs, Integer stock, float price);
    int changeStock(Integer newStock, Integer goodSpecsId);
    int changePrice(float newPrice, Integer goodSpecsId);
    int deleteSpecs(Integer goodSpecsId);
    int deleteGoods(Integer goodsId);
    String getKeyName(int id);
    GoodsAttrValue getValueName(int id);
    String getSpecsById(int id);
    Goods getGoodById(int good_id);
    List<String> getSpecs(int good_id);
    List<GoodsAttrValue> getValuesByKey(int key_id);
    int getKeyId(int id);
    float getPrice(int id);
    Map<String,Object> getStockPrice(int good_id, String specs);
    void changeSpecs(int id, String specs);
    SingleOrderItem getGoodBySpecsId(int id);
    void changeGoodImg(String url,int goodId);
    void changeSpecImg(String url,int id);
}
