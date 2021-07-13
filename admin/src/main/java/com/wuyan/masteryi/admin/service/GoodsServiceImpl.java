package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.*;
import com.wuyan.masteryi.admin.mapper.CategoryMapper;
import com.wuyan.masteryi.admin.mapper.GoodsMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CategoryMapper categoryMapper;

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
    public Map<String, Object> getAllSpecs(Integer []goods_id) {
        List<List<Map>> result=new ArrayList<>();
        for(int gid :goods_id)
        {
            List<Map> res = new ArrayList<>();
            List<GoodSpecs> speces = goodsMapper.getAllSpecs(gid);
            for (GoodSpecs spec : speces) {
                Map<String, Object> perRes = new HashMap<>();
                perRes.put("id", spec.getId());
                perRes.put("goodId", spec.getGoodsId());
                Map<String, String> specDetail = new HashMap<>();
                String s = spec.getSpecs();
                String[] split = s.split(",");
                for (String ss : split) {
                    specDetail.put(goodsMapper.getKeyName(Integer.parseInt(ss.split(":")[0])), goodsMapper.getValueName(Integer.parseInt(ss.split(":")[1])).getValueName());
                }
                perRes.put("specDetail", specDetail);
                perRes.put("price", spec.getPrice());
                perRes.put("stock", spec.getStock());
                res.add(perRes);
            }
            result.add(res);
        }
        return ResponseMsg.sendMsg(200, "成功获取所有商品信息", result);
    }

    @Override
    public Map<String, Object> addGood(String goodsName, String goodsInformation, Integer goodsCategoryId,
                                       String goodsCoverUrl, Integer collectNum, Integer sellNum,int [] specs,float primaryPrice) {

        Goods goods=new Goods(0,goodsName,goodsInformation,goodsCategoryId,goodsCoverUrl,collectNum,sellNum,primaryPrice);
        goodsMapper.addGood(goods);
        int goodId=goods.getGoodsId();
        int []temp=new int[specs.length];
        int cnt=0;
        for(int i=0;i<specs.length;i++){
            List<AttrItem> keyMapValue = categoryMapper.getKeyMapValue(specs[i]);
            if(keyMapValue.size()>0){
                temp[cnt]=Integer.parseInt(keyMapValue.get(0).getValueId());
                cnt++;
            }
        }
        int []res=new int[cnt];
        for(int i=0;i<cnt;i++) res[i]=temp[i];
        return addSpecs(goodId,res,0,primaryPrice);
    }
//
    @Override
    public Map<String, Object> addSpecs(Integer goodsId, int []specs, Integer stock, float price) {
        String res="";
        int []keys=new int[specs.length];
        for(int i=0;i<specs.length;i++){
            keys[i]=goodsMapper.getKeyId(specs[i]);
        }
        for(int i =0 ; i<specs.length-1 ; i++) {
            for(int j=0 ; j<specs.length-1-i ; j++) {
                if(specs[j]>specs[j+1]) {
                    int temp = specs[j];
                    int temp2=keys[j];
                    specs[j]=specs[j+1];
                    keys[j]=keys[j+1];
                    specs[j+1]=temp;
                    keys[j+1]=temp2;
                }
            }
        }
        for(int i =0;i<specs.length;i++){
            if(i<specs.length-1){
                res=res+keys[i]+":"+specs[i]+",";
            }
            else res=res+keys[i]+":"+specs[i];
        }
        if(goodsMapper.getStockPrice(goodsId,res)!=null) return ResponseMsg.sendMsg(100,"该规格商品已存在",null);
        else {
            goodsMapper.addSpecs(goodsId,res,stock,price);
            return ResponseMsg.sendMsg(200,"添加成功","ok");
        }
        //return ResponseMsg.sendMsg(200, "成功添加属性", goodsMapper.addSpecs(goodsId, specs, stock, price));
    }

    @Override
    public Map<String, Object> changeStock(Integer newStock, Integer goodSpecsId) {
        return ResponseMsg.sendMsg(200, "成功改变库存", goodsMapper.changeStock(newStock, goodSpecsId));
    }

    @Override
    public Map<String, Object> changePrice(float newPrice, Integer goodSpecsId) {
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
        Map<String, String> res=new HashMap<>();
        String[] split = s.split(",");
        for(String ss:split){
            res.put(goodsMapper.getKeyName(Integer.parseInt(ss.split(":")[0])),
                    goodsMapper.getValueName(Integer.parseInt(ss.split(":")[1])).getValueName());
        }
        return ResponseMsg.sendMsg(200,"查询成功",res);
    }
    @Override
    public Map<String,Object> getGoodTypes(int good_id) {
        Map<String, Set<String>> temp=new HashMap<>();
        List<String> strings=goodsMapper.getSpecs(good_id);
        Map<String,List<GoodsAttrValue>> res=new HashMap<>();

        String[] split = strings.get(0).split(",");
        for (String value : split) {
            temp.put(value.split(":")[0], new HashSet<>());
        }
        for(String s:strings){
            String[] split1 = s.split(",");
            for(String ss:split1){
                temp.get(ss.split(":")[0]).add(ss.split(":")[1]);
            }
        }
        for(String key:temp.keySet()){
            List<GoodsAttrValue> goodsAttrValues=new ArrayList<>();
            for(String value:temp.get(key)){
                goodsAttrValues.add(goodsMapper.getValueName(Integer.parseInt(value)));
            }
            res.put(goodsMapper.getKeyName(Integer.parseInt(key)),goodsAttrValues);
        }

        return ResponseMsg.sendMsg(200,"查询成功",res);
    }

    @Override
    public Map<String, Object> getValuesByKey(int []key_id) {
        List<List<GoodsAttrValue>> l=new ArrayList<>();
        for(int i :key_id){
            l.add(goodsMapper.getValuesByKey(i));
        }
        return ResponseMsg.sendMsg(200,"查询成功",l);
    }

    @Override
    public Map<String, Object> changeSpecs(int id, int[] specs) {
        String res="";
        int []keys=new int[specs.length];
        for(int i=0;i<specs.length;i++){
            keys[i]=goodsMapper.getKeyId(specs[i]);
        }
        for(int i =0 ; i<specs.length-1 ; i++) {
            for(int j=0 ; j<specs.length-1-i ; j++) {
                if(specs[j]>specs[j+1]) {
                    int temp = specs[j];
                    int temp2=keys[j];
                    specs[j]=specs[j+1];
                    keys[j]=keys[j+1];
                    specs[j+1]=temp;
                    keys[j+1]=temp2;
                }
            }
        }
        for(int i =0;i<specs.length;i++){
            if(i<specs.length-1){
                res=res+keys[i]+":"+specs[i]+",";
            }
            else res=res+keys[i]+":"+specs[i];
        }
        goodsMapper.changeSpecs(id,res);

        return ResponseMsg.sendMsg(200,"ok","ok");
    }

    @Override
    public Map<String, Object> getGoodBySpecsId(int id) {
        SingleOrderItem goodBySpecsId = goodsMapper.getGoodBySpecsId(id);
        goodBySpecsId.setDescription((Map<String, String>) getSpecsDesc(goodBySpecsId.getId()).get("data"));
        return ResponseMsg.sendMsg(200,"ok",goodBySpecsId);
    }
}
