package com.wuyan.masteryi.admin.service;

import java.util.Map;

public interface SecKillService {
    Map<String,Object> addSkGoods(Integer prodId, Integer stock);
    Map<String,Object> rmSkGoods(Integer propId);
}
