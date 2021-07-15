package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.service.GetUidServerImpl;
import com.wuyan.masteryi.mall.service.SecKillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/seckill")
@Api(tags = "秒杀接口")
public class SecKillController {

    @Autowired
    SecKillService secKillService;

    @Autowired
    GetUidServerImpl getUidServer;

    @GetMapping("/comfirm")
    @ResponseBody
    @ApiOperation(value = "秒杀测试",notes = "秒杀测试")
    public Map<String, Object> secKill (@RequestHeader("token")String token, String prodid){
        return  secKillService.doSecKill(getUidServer.getStringUid(token), prodid);

    }

    @GetMapping("/getAllInfo")
    @ResponseBody
    @ApiOperation(value = "获取秒杀商品信息",notes = "获取秒杀商品信息")
    public Map<String, Object> getAllInfo (){
        return  secKillService.getAllSk();

    }
}
