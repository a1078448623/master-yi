package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.Goods;
import com.wuyan.masteryi.admin.mapper.GoodsMapper;
import com.wuyan.masteryi.admin.mapper.SkGoodsMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class SecKillServiceImpl implements SecKillService {

//    @Autowired
//    private RedisTemplate redisTemplate;
    @Autowired
    SkGoodsMapper skGoodsMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map<String, Object> addSkGoods(int[] prodId, int[] stock, int[] price, String bDate, String eDate) {
        HostAndPort hostAndPort = new HostAndPort("49.232.159.181", 6379);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int data = 0;
//        redisTemplate.opsForSet().add("allSk", prodId);//添加秒杀商品到秒杀商品库
//        redisTemplate.opsForValue().set(kcKey, stock);//添加秒杀商品库存

        for(int i = 0; i < prodId.length; i++) {
            String pid = prodId[i] + "";
            String kcKey = "{sk}:"+pid+":st";
            jedisCluster.set(kcKey, String.valueOf(stock[i]));
            System.out.println(jedisCluster.get(kcKey));
            jedisCluster.sadd("allSk", String.valueOf(prodId[i]));

            Goods good = goodsMapper.getGoodById(prodId[i]);

            skGoodsMapper.setSkGoods(prodId[i]+"",good.getGoodsName(),good.getGoodsCoverUrl(), stock[i], price[i],
                    goodsMapper.getPrice(prodId[i]),formatter.format(Long.valueOf(bDate)), formatter.format(Long.valueOf(eDate)));
            data ++;
        }

        return ResponseMsg.sendMsg(200, "成功创建秒杀项目", data);
    }

    @Override
    public Map<String, Object> rmSkGoods(Integer prodId) {
//        String kcKey = "sk:"+prodId+":st";
//        String userKey = "sk:"+prodId+":usr";
////        Long result1 = redisTemplate.boundSetOps("allSk").remove(prodId);
////        redisTemplate.delete(kcKey);
////        redisTemplate.delete(userKey);

        return ResponseMsg.sendMsg(200, "成功删除秒杀项目", skGoodsMapper.deleteSkGoods(prodId+""));
    }
}
