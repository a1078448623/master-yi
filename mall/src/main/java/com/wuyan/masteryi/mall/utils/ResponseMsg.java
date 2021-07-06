package com.wuyan.masteryi.mall.utils;
/*
 *project:master-yi
 *file:ResponseMsg
 *@author:wsn
 *date:2021/7/6 14:22
 */

import java.util.HashMap;
import java.util.Map;

public class ResponseMsg {
    private static final Map<String,Object> res=new HashMap();
    public static Map<String,Object> sendMsg(int code,String msg,Object data){

        res.put("code",code);
        res.put("msg",msg);
        res.put("data",data);
        return res;
    }
}
