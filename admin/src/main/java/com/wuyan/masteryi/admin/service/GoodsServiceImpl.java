package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.Goods;
import com.wuyan.masteryi.admin.mapper.GoodsMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map<String, Object> getAllGoods(){
        return ResponseMsg.sendMsg(200, "成功获取所有商品信息", goodsMapper.getAllGoods());
    }

    @Override
    public Map<String, Object> getParentCategoryGoods(Integer parentId) {
        List<Goods> res = new ArrayList<Goods>();
        List<Integer> childIds = goodsMapper.getChildCategoryByParentId(parentId);
        for(Integer childId:childIds) {
            res.addAll(goodsMapper.getChildCategoryGoods(childId));
        }
        return ResponseMsg.sendMsg(200, "成功获取所有商品信息", res);
    }

    @Override
    public Map<String, Object> getChildCategoryGoods(Integer childId) {
        return ResponseMsg.sendMsg(200, "成功获取所有商品信息", goodsMapper.getChildCategoryGoods(childId));
    }

    @Override
    public Map<String, Object> getAllSpecs(Integer goods_id) {
        return ResponseMsg.sendMsg(200, "成功获取所有商品信息", goodsMapper.getAllSpecs(goods_id));
    }

    @Override
    public Map<String, Object> addGood(String goodsName, String goodsInformation, Integer goodsCategoryId,
                                       String goodsCoverUrl, Integer collectNum, Integer sellNum) {
        return ResponseMsg.sendMsg(200, "成功添加商品", goodsMapper.addGood(goodsName, goodsInformation, goodsCategoryId,goodsCoverUrl,collectNum,sellNum));
    }

    @Override
    public Map<String, Object> addSpecs(Integer goodsId, String specs, Integer stock, float price) {
        return ResponseMsg.sendMsg(200, "成功添加属性", goodsMapper.addSpecs(goodsId, specs, stock, price));
    }

    @Override
    public Map<String, Object> changeStock(Integer newStock, Integer goodSpecsId) {
        return ResponseMsg.sendMsg(200, "成功改变库存", goodsMapper.changeStock(newStock, goodSpecsId));
    }

    @Override
    public Map<String, Object> changePrice(Integer newPrice, Integer goodSpecsId) {
        return ResponseMsg.sendMsg(200, "成功改变价格", goodsMapper.changePrice(newPrice, goodSpecsId));
    }

    @Override
    public Map<String, Object> deleteSpecs(Integer goodSpecsId) {
        return ResponseMsg.sendMsg(200, "成功删除属性", goodsMapper.deleteSpecs(goodSpecsId));
    }

    @Override
    public Map<String, Object> deleteGoods(Integer goodsId) {
        return ResponseMsg.sendMsg(200, "成功删除商品", goodsMapper.deleteGoods(goodsId));
    }
    @Override
    public Map<String, Object> getSpecsDesc(int id) {
        String s=goodsMapper.getSpecsById(id);
        Map<String,String> res=new HashMap<>();
        String[] split = s.split(",");
        for(String ss:split){
            res.put(goodsMapper.getKeyName(Integer.parseInt(ss.split(":")[0])),
                    goodsMapper.getValueName(Integer.parseInt(ss.split(":")[1])).getValueName());
        }
        return ResponseMsg.sendMsg(200,"查询成功",res);
    }
}
