package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:GoodsServiceImpl
 *@author:wsn
 *date:2021/7/6 15:07
 */

import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Map<String,Object> descStock(int[] good_id, int[] num) {
        int flag=1;
        for (int i = 0; i < good_id.length; i++) {
            if(goodsMapper.descStock(good_id[i],num[i])==0){
                flag=0;break;
            }
        }

        if(flag>0) return ResponseMsg.sendMsg(200,"更改成功",true);
        else return ResponseMsg.sendMsg(100,"更改失败，库存不足",false);
    }

    @Override
    public Map<String, Object> getGoodById(int good_id) {
        if(goodsMapper.getGoodById(good_id)==null){
            return ResponseMsg.sendMsg(100,"没有商品",null);
        }
        else return ResponseMsg.sendMsg(200,"查询成功",goodsMapper.getGoodById(good_id));
    }
}
