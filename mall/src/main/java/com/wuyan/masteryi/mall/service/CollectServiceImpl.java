package com.wuyan.masteryi.mall.service;

import com.wuyan.masteryi.mall.mapper.CollectMapper;
import com.wuyan.masteryi.mall.mapper.GoodsMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map<String, Object> addToCollect(Integer userId, Integer goodsId) {
        goodsMapper.addCollect(goodsMapper.getGoodIdBySpecId(goodsId));
        return ResponseMsg.sendMsg(200, "成功添加到收藏夹", collectMapper.addToCollect(userId, goodsId));
    }

    @Override
    public Map<String, Object> deleteFromCollect(Integer collectId) {
        goodsMapper.subCollect(goodsMapper.getGoodIdBySpecId(collectMapper.getGoodByCollectId(collectId)));
        return ResponseMsg.sendMsg(200, "成功从收藏夹删除", collectMapper.deleteFromCollect(collectId));
    }

    @Override
    public Map<String, Object> showMyCollect(Integer userId) {
        return ResponseMsg.sendMsg(200, "获取收藏夹成功", collectMapper.showMyCollect(userId));
    }

    @Override
    public Map<String, Object> isCollect(Integer userId, Integer specId) {
        return ResponseMsg.sendMsg(200, "获取收藏状态成功", collectMapper.isCollect(userId, specId));
    }
}
