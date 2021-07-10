package com.wuyan.masteryi.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
@Api(tags = "redis测试")
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/getName")
    @ApiOperation(value = "获取redis数据",notes = "获取redis数据")
    public String testRedis(){
        //设置值
        //redisTemplate.opsForValue().set("jkl","jkl2");
        return (String)redisTemplate.opsForValue().get("jkl");
    }

}
