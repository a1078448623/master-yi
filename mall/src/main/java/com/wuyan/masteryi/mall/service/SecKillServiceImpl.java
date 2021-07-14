package com.wuyan.masteryi.mall.service;

//import com.wuyan.masteryi.mall.utils.JedisPoolUtil;
import com.wuyan.masteryi.mall.entity.Goods;
import com.wuyan.masteryi.mall.entity.SkGoods;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.mapper.SkGoodsMapper;
import com.wuyan.masteryi.mall.mapper.UserMapper;
import com.wuyan.masteryi.mall.utils.JedisPoolUtil;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.util.JedisClusterCRC16;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SecKillServiceImpl implements SecKillService{

    @Autowired
    OrderService orderService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SkGoodsMapper skGoodsMapper;

    //lua 脚本
    static String secKillScript =
            "local qtkey=KEYS[1];\r\n" +
            "local usersKey=KEYS[2];\r\n" +
//            "local qtkey='{sk}:'..prodid..\":st\";\r\n" +
//            "local usersKey='{sk}:'..prodid..\":usr\";\r\n" +
            "local userExists=redis.call(\"sismember\",usersKey,usersKey);\r\n"+
            "if tonumber(userExists)==1 then \r\n" +
            "   return 2;\r\n" +
            "end\r\n" +
            "local num= redis.call(\"get\" ,qtkey);\r\n" +
            "if tonumber(num)<=0 then \r\n" +
            "   return 0;\r\n" +
            "else \r\n" +
            "   redis.call(\"decr\",qtkey);\r\n" +
            "   redis.call(\"sadd\",usersKey,usersKey);\r\n" +
            "end\r\n" +
            "return 1" ;

    static String secKillScript2 =
            "local userExists=redis.call(\"sismember\",\"{sk}:0101:usr\",userid);\r\n" +
                    " return 1";

    //实现秒杀
    @Override
    public Map<String,Object> doSecKill(String uid, String prodid) {

//        JedisPool jedispool =  JedisPoolUtil.getJedisPoolInstance();
//        Jedis jedis=jedispool.getResource();

        HostAndPort hostAndPort = new HostAndPort("49.232.159.181", 6379);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort);
        System.out.println(JedisClusterCRC16.getSlot("{sk}:5:st"));
        System.out.println(JedisClusterCRC16.getSlot("{sk}:5:usr"));

//        String sha1=  jedis.scriptLoad(secKillScript);
//        Object result= jedis.evalsha(sha1, 2, uid,prodid);

//        String sha1=  jedisCluster.scriptLoad(secKillScript, "sk1");
//        Object result= jedisCluster.evalsha(sha1, 2, uid,prodid);
        String kcKey = "{sk}:"+prodid+":st";
        System.out.println(kcKey);
        String userKey = "{sk}:"+uid+":usr";
        Object result = jedisCluster.eval(secKillScript,2,kcKey,userKey);

        String reString=String.valueOf(result);
        if ("0".equals( reString )  ) {
            System.err.println("已抢空！！");
        }else if("1".equals( reString )  )  {
            System.out.println("抢购成功！！！！");

            int[] goods = {Integer.parseInt(prodid)};
            int[] num = {1};
            float[] price = {skGoodsMapper.getPrice(prodid)};
            String address = userMapper.getAddr(Integer.parseInt(prodid));

            //创建订单
            orderService.creatOrder(goods, num, price, Integer.parseInt(uid),1, price[0], address);

        }else if("2".equals( reString )  )  {
            System.err.println("该用户已抢过！！");
        }else{
            System.err.println("抢购异常！！");
        }
        try {
            jedisCluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseMsg.sendMsg(200,"设置成功",result);

    }

    @Override
    public Map<String, Object> getAllSk() {
        return  ResponseMsg.sendMsg(200,"设置成功",skGoodsMapper.getAllSk());
    }
}
