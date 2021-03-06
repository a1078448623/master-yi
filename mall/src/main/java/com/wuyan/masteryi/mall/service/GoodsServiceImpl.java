package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:GoodsServiceImpl
 *@author:wsn
 *date:2021/7/6 15:07
 */

import com.wuyan.masteryi.mall.entity.GoodSpecs;
import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.entity.GoodsAttrValue;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map<String,Object> getAllGoods() {
        List<Goods> goodsList=goodsMapper.getAllGoods();
        if(goodsList!=null){
            return ResponseMsg.sendMsg(200,"请求成功",goodsList);
        }
        else {
            return ResponseMsg.sendMsg(100,"没有商品",null);
        }
    }

    @Override
    public Map<String,Object> addSell(int []good_id, int []num) {
        int flag=1;
        for (int i = 0; i < good_id.length; i++) {
            if(goodsMapper.addSell(good_id[i],num[i])==0){
                flag=0;break;
            }
        }
        if(flag>0) return ResponseMsg.sendMsg(200,"更改成功",true);
        else return ResponseMsg.sendMsg(100,"更改失败，库存不足",false);
    }

    @Override
    public Map<String,Object> addCollect(int good_id) {
        int i=goodsMapper.addCollect(good_id);
        if(i>0) return ResponseMsg.sendMsg(200,"更改成功",true);
        else return ResponseMsg.sendMsg(100,"更改失败",false);
    }

    @Override
    public Map<String, Object> getStockPrice(int good_id, int []specs) {
        String res="";
        int []keys=new int[specs.length];
        for(int i=0;i<specs.length;i++){
            System.out.println(specs[i]);
            keys[i]=goodsMapper.getKeyId(specs[i]);
            System.out.println(keys[i]);
        }
        System.out.println("11111111");
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
        Map<String,Object> m=goodsMapper.getStockPrice(good_id,res);

        return ResponseMsg.sendMsg(200,"查询成功",m);
    }


    @Override
    public Map<String, Object> getGoodById(int good_id) {
        if(goodsMapper.getGoodById(good_id)==null){
            return ResponseMsg.sendMsg(100,"没有商品",null);
        }
        else return ResponseMsg.sendMsg(200,"查询成功",goodsMapper.getGoodById(good_id));
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
    @Override
    public Map<String, Object> getGoodsByType(int category_id) {
        List<Goods> goodsList=goodsMapper.getGoodsByType(category_id);
        if(goodsList==null) return ResponseMsg.sendMsg(100,"该分类下没有商品",null);
        else return ResponseMsg.sendMsg(200,"查询成功",goodsList);
    }

    @Override
    public Map<String, Object> searchInAllGoods(String searchName) {
        List<Goods> goodsList = goodsMapper.searchInAllGoods(searchName);
        if(goodsList.size()==0) return ResponseMsg.sendMsg(100,"没有商品",null);
        else return ResponseMsg.sendMsg(200,"查询成功",goodsList);

    }

    @Override
    public Map<String, Object> searchGoodsCategory(String searchName, int categoryId) {
        List<Goods> goodsList = goodsMapper.searchGoodsCategory(searchName, categoryId);

        if(goodsList.size()==0) return ResponseMsg.sendMsg(100,"没有商品",null);
        else return ResponseMsg.sendMsg(200,"查询成功",goodsList);
    }

    @Override
    public Map<String, Object> getAllSpecs(Integer[] goods_id) {
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
}
