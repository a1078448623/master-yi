package com.wuyan.masteryi.admin.service;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.wuyan.masteryi.admin.config.AliPayConfig;
import com.wuyan.masteryi.admin.entity.Order;
import com.wuyan.masteryi.admin.entity.SingleOrderItem;
import com.wuyan.masteryi.admin.mapper.OrderMapper;
import com.wuyan.masteryi.admin.utils.OrderStatu;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/8 14:56
 * @Description:
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsService goodsService;

    @Override
    public Map<String, Object> getAllOrder() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<Order> allOrder = orderMapper.getAllOrder();
        for(Order order:allOrder){
            order.setFormate_time(sdf.format(order.getCreateTime()));
            order.setStatu(OrderStatu.getStatu(order.getOrderStatus()));
            order.setCreateTime(null);
        }
        return ResponseMsg.sendMsg(200, "成功获取所有订单", allOrder);
    }

    @Override
    public Map<String, Object> getOneUserOrder(Integer userId) {
        return ResponseMsg.sendMsg(200, "成功获取该用户订单", orderMapper.getOneUserOrder(userId));
    }

    @Override
    public Map<String, Object> getOrderItem(Integer orderId) {



        List<SingleOrderItem> goodsList=orderMapper.getOrderItem(orderId);
        System.out.println(goodsList);
        for(SingleOrderItem singleOrderItem:goodsList){
            singleOrderItem.setDescription((Map<String, String>) goodsService.getSpecsDesc(singleOrderItem.getId()).get("data"));
        }
        return ResponseMsg.sendMsg(200,"查询成功",goodsList);

    }

    @Override
    public Map<String, Object> dealRefund(Integer orderId, Boolean agree) {
        AlipayClient alipayClient = new DefaultAlipayClient
                (AliPayConfig.serverUrl,
                        AliPayConfig.Appid,
                        AliPayConfig.privateKey,
                        AliPayConfig.formate,
                        AliPayConfig.charset,
                        AliPayConfig.AliPayPublicKey,
                        AliPayConfig.signType );
        AlipayTradeRefundRequest req = new AlipayTradeRefundRequest();
        Order order = orderMapper.getOrderById(orderId);

        String pool="A1B2C3D4E5F6G7H8I9JKLMNOPQRSTUVWXYZ";
        Random random=new Random();
        String out_request_no="";
        for(int i=0;i<12;i++){
            int indes = random.nextInt(35);
            out_request_no+=pool.charAt(indes);
        }
        String out_trade_no=order.getOrderNo();
        String refund_amount=order.getOrderTotalPrice()+"";
        req.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"refund_amount\":\"" + refund_amount + "\","
                + "\"out_request_no\":\"" + out_request_no + "\"}");
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(req);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            return ResponseMsg.sendMsg(200, "同意退款请求", orderMapper.agreeRefund(orderId));
        } else {
            return ResponseMsg.sendMsg(200, "拒绝退款请求", orderMapper.disagreeRefund(orderId));
        }

    }

    @Override
    public Map<String, Object> delOrder(int orderId) {
        return ResponseMsg.sendMsg(200,"请求成功",orderMapper.delOrder(orderId));
    }
}
