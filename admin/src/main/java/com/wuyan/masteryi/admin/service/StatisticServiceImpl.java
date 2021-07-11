package com.wuyan.masteryi.admin.service;
/*
 *project:master-yi
 *file:Statistic
 *@author:wsn
 *date:2021/7/11 16:24
 */

import com.wuyan.masteryi.admin.entity.OrderCount;
import com.wuyan.masteryi.admin.entity.Statistic;
import com.wuyan.masteryi.admin.mapper.StatisticMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService{

    @Autowired
    StatisticMapper statisticMapper;

    @Override
    public Map<String, Object> getBasicData() {
        return ResponseMsg.sendMsg(200,"查询成功",
                new Statistic(statisticMapper.getSalesNum(),statisticMapper.getEraningNum(),
                        statisticMapper.getVisitorNum(),statisticMapper.getUserNum(),statisticMapper.getOrderNum()));
    }

    @Override
    public Map<String,Object> getOrderCount(){
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
        List<OrderCount> orderCount = statisticMapper.getOrderCount();
        for(OrderCount orderCount1:orderCount){
            orderCount1.setF_date(sdf.format(orderCount1.getDate()));
            orderCount1.setDate(null);
        }
        return ResponseMsg.sendMsg(200,"ok",orderCount);
    }
}
