package com.wuyan.masteryi.admin.service;

import java.util.List;
import java.util.Map;

public interface SecKillService {
    Map<String,Object> addSkGoods(int[] prodId, int[] stock, int[] price, String bDate, String eDate);
    Map<String,Object> rmSkGoods(Integer propId);
}
