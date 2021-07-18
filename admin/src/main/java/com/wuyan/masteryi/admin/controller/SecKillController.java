package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.mapper.UserMapper;
import com.wuyan.masteryi.admin.service.SecKillService;
//import com.wuyan.masteryi.admin.utils.ShiroUtil;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import com.wuyan.masteryi.admin.utils.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seckill")
@Api(tags ="秒杀管理接口")
public class SecKillController {
    @Autowired
    SecKillService secKillService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/addSkGoods")
    @ApiOperation(value = "添加秒杀商品",notes = "添加秒杀商品")
    public Map<String, Object> addSkGoods(int[] prodId, int[] stock, int[] price, String bDate, String eDate){
        return secKillService.addSkGoods(prodId, stock, price, bDate, eDate);
    }

    @PostMapping("/rmSkGoods")
    @ApiOperation(value = "删除秒杀商品",notes = "删除秒杀商品")
    public Map<String, Object> testRedis(Integer prodId) {
        return secKillService.rmSkGoods(prodId);
    }
}
