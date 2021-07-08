package com.wuyan.masteryi.mall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuyan.masteryi.mall.entity.User;
import com.wuyan.masteryi.mall.utils.TokenUtil ;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ Program       :  com.ljnt.jwt_login.controller.Login
 * @ Description   :  login控制类
 * @ Author        :  lj
 * @ CreateDate    :  2021-7-7 14:32
 */
@RestController
public class Login {

    @PostMapping("/login")
    @ResponseBody
    public String login(String username,String password) throws JsonProcessingException {
        //可以在此处检验用户密码
        User user=new User();
        user.setUserName(username);
        user.setUserPwd(password);
        String token= TokenUtil.sign(user);
        HashMap<String,Object> hs=new HashMap<>();
        hs.put("token",token);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(hs);
    };
}