package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:TradeServiceImpl
 *@author:wsn
 *date:2021/7/7 19:57
 */

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.wuyan.masteryi.mall.config.AliPayConfig;
import com.wuyan.masteryi.mall.entity.Order;
import com.wuyan.masteryi.mall.entity.OrderItem;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.mapper.OrderItemMapper;
import com.wuyan.masteryi.mall.mapper.OrderMapper;
import com.wuyan.masteryi.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class TradeServiceImpl implements TradeService{
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public String aliPay(int order_id, String orderNo) throws IOException {
        //去沙箱里面找自己的
        AlipayClient alipayClient = new DefaultAlipayClient
                (AliPayConfig.serverUrl,
                AliPayConfig.Appid,
                AliPayConfig.privateKey,
                AliPayConfig.formate,
                AliPayConfig.charset,
                AliPayConfig.AliPayPublicKey,
                AliPayConfig.signType );
        Order order=orderMapper.getOrdersById(order_id);
        //订单号  自定义
//        String out_trade_no = "20207282414329595224072521";
        String out_trade_no=order.getOrderNo();
        out_trade_no = URLDecoder.decode(out_trade_no,"UTF-8");
        String total_amount = order.getOrderTotalPrice()+"";
        total_amount = URLDecoder.decode(total_amount,"UTF-8");
        String subject = "111";
        subject = URLDecoder.decode(subject,"UTF-8");
        String body = "易大师交易平台";
        body = URLDecoder.decode(body,"UTF-8");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        //同步通知
        alipayRequest.setReturnUrl(AliPayConfig.returnURL);
        //异步通知
        alipayRequest.setNotifyUrl(AliPayConfig.notifyURL);
        String timeout_express = "1m";
        //配置参数
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+ out_trade_no +"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+ total_amount +"," +
                "    \"subject\":\""+ subject +"\"," +
                "    \"timeout_express\":\""+ timeout_express +"\","+
                "    \"body\":\""+ body +"\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //form就是一个表单 html 直接给前端 替换 body标签里面的东西
        //System.out.println(form);
        return  form;
    }

    @Override
    public String payCallback(HttpServletRequest httpServletRequest) {
        System.out.println("回调页面");
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            System.out.println("key==="+name+"----value==="+valueStr);
            params.put(name, valueStr);
        }
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params,
                    AliPayConfig.AliPayPublicKey,
                    AliPayConfig.charset,
                    AliPayConfig.signType); // 调用SDK验证签名
            System.out.println(params.get("trade_status"));
            if(signVerified){
                orderMapper.changeStatu(params.get("out_trade_no"),2);
                List<OrderItem> items = orderItemMapper.getItemsByNo(params.get("out_trade_no"));
                for(OrderItem item:items) {
                    goodsMapper.addSell(item.getGoodsId(),item.getGoodsNum());
                }
                Order order = orderMapper.getOrdersByNo(params.get("out_trade_no"));
                userMapper.addConsumption(order.getUserId(),order.getOrderTotalPrice());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        
        return "n";
    }
}
