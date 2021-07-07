package com.wuyan.masteryi.admin.utils;


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
