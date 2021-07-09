package com.wuyan.masteryi.admin.mapper;

import com.wuyan.masteryi.admin.entity.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    List<Goods> getAllGoods();
    List<Integer> getChildCategoryByParentId(Integer parentId);
    List<Goods> getChildCategoryGoods(Integer childId);
    List<GoodSpecs> getAllSpecs(Integer goods_id);
    int addGood(String goodsName, String goodsInformation, Integer goodsCategoryId,
                            String goodsCoverUrl, Integer collectNum, Integer sellNum);
    int addSpecs(Integer goodsId, String specs, Integer stock, float price);
    int changeStock(Integer newStock, Integer goodSpecsId);
    int changePrice(Integer newPrice, Integer goodSpecsId);
    int deleteSpecs(Integer goodSpecsId);
    int deleteGoods(Integer goodsId);
    String getKeyName(int id);
    GoodsAttrValue getValueName(int id);
    String getSpecsById(int id);
}
