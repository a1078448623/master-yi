package com.wuyan.masteryi.mall.service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

public interface CollectService {
    Map<String, Object> addToCollect(Integer userId, Integer goodsId);
    Map<String, Object> deleteFromCollect(Integer collectId);
    Map<String, Object> showMyCollect(Integer userId);
    Map<String, Object> isCollect(Integer userId, Integer specId);
}
