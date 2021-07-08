package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:TradeService
 *@author:wsn
 *date:2021/7/7 19:56
 */

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface TradeService {

    String aliPay(int order_id,String orderNo)throws IOException;
    String payCallback(HttpServletRequest httpServletRequest);
}
