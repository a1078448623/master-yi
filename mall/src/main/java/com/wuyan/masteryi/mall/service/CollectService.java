package com.wuyan.masteryi.mall.service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

public interface CollectService {
    public Map<String, Object> addToCollect(Integer userId, Integer goodsId);
    public Map<String, Object> deleteFromCollect(Integer collectId);
}
