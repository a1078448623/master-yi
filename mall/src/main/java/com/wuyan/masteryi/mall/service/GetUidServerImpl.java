package com.wuyan.masteryi.mall.service;

import com.wuyan.masteryi.mall.utils.TokenUtil;
import org.springframework.stereotype.Service;

@Service
public class GetUidServerImpl {
    public int getintUid (String token){
        return TokenUtil.getUid(token);
    }

    public Integer getIntegerUid (String token){
        return new Integer(TokenUtil.getUid(token));
    }

    public String getStringUid(String token){
        return TokenUtil.getUid(token)+"";
    }
}
