package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.service.SecKillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/seckill")
@Api(tags ="秒杀管理接口")
public class SecKillController {
    @Autowired
    SecKillService secKillService;

    @PostMapping("/addSkGoods")
    @ApiOperation(value = "添加秒杀商品",notes = "添加秒杀商品")
    public Map<String, Object> addSkGoods(Integer prodId, Integer stock){
        return secKillService.addSkGoods(prodId, stock);
    }

    @PostMapping("/rmSkGoods")
    @ApiOperation(value = "删除秒杀商品",notes = "删除秒杀商品")
    public Map<String, Object> testRedis(Integer prodId) {
        return secKillService.rmSkGoods(prodId);
    }

    @PostMapping("/testdate")
    public void testDate(String begin,String end){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(begin);

        System.out.println(sdf.format(Long.valueOf(begin)));
        System.out.println(sdf.format(Long.valueOf(end)));
    }
}
