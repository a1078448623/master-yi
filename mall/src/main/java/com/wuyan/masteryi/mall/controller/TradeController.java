package com.wuyan.masteryi.mall.controller;
/*
 *project:master-yi
 *file:TradeController
 *@author:wsn
 *date:2021/7/7 19:53
 */

import com.wuyan.masteryi.mall.service.TradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@Api(tags = "交易接口")
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @PostMapping("/pay")
    @ApiOperation(value = "支付",notes = "传订单id和订单号进行支付")
    public String aliPay(int order_id,String orderNo){
        try {
            return tradeService.aliPay(order_id,orderNo);
        } catch (IOException e) {
            return null;
        }
    }

    @RequestMapping("/payCallback")
    @ApiOperation(value = "异步回调接口",notes = "支付宝异步回调接口")
    public String payCallback(HttpServletRequest httpServletRequest){
        return tradeService.payCallback(httpServletRequest);
    }
}
