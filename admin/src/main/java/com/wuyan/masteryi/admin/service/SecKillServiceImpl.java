package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> addSkGoods(Integer prodId, Integer stock) {
        String kcKey = "sk:"+prodId+":st";
        String userKey = "sk:"+prodId+":usr";
        redisTemplate.opsForSet().add("allSk", prodId);//添加秒杀商品到秒杀商品库
        redisTemplate.opsForValue().set(kcKey, stock);//添加秒杀商品库存
        return ResponseMsg.sendMsg(200, "成功创建秒杀项目", 1);
    }

    @Override
    public Map<String, Object> rmSkGoods(Integer prodId) {
        String kcKey = "sk:"+prodId+":st";
        String userKey = "sk:"+prodId+":usr";
        Long result1 = redisTemplate.boundSetOps("allSk").remove(prodId);
        redisTemplate.delete(kcKey);
        redisTemplate.delete(userKey);
        return ResponseMsg.sendMsg(200, "成功删除秒杀项目", result1);
    }
}
