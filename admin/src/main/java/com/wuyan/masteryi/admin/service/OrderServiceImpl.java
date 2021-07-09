package com.wuyan.masteryi.admin.service;


import com.wuyan.masteryi.admin.entity.SingleOrderItem;
import com.wuyan.masteryi.admin.mapper.OrderMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return ResponseMsg.sendMsg(200, "成功获取所有订单", orderMapper.getAllOrder());
    }

    @Override
    public Map<String, Object> getOneUserOrder(Integer userId) {
        return ResponseMsg.sendMsg(200, "成功获取该用户订单", orderMapper.getOneUserOrder(userId));
    }

    @Override
    public Map<String, Object> getOrderItem(Integer orderId) {



        List<SingleOrderItem> goodsList=orderMapper.getOrderItem(orderId);
        for(SingleOrderItem singleOrderItem:goodsList){
            singleOrderItem.setDescription((Map<String, String>) goodsService.getSpecsDesc(singleOrderItem.getId()).get("data"));
        }
        return ResponseMsg.sendMsg(200,"查询成功",goodsList);

    }

    @Override
    public Map<String, Object> dealRefund(Integer orderId, Boolean agree) {
        if(agree) return ResponseMsg.sendMsg(200, "同意退款请求", orderMapper.agreeRefund(orderId));
        else return ResponseMsg.sendMsg(200, "拒绝退款请求", orderMapper.disagreeRefund(orderId));
    }
}
