package com.wuyan.masteryi.mall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuyan.masteryi.mall.entity.LoginUser;
import com.wuyan.masteryi.mall.mapper.UserMapper;
import com.wuyan.masteryi.mall.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
@Api(tags = "登录接口")
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/comfirm")
    @ResponseBody
    @ApiOperation(value = "登录测试",notes = "登录测试")
    public String login(String username,String password) throws JsonProcessingException {
        HashMap<String,Object> hs=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        //判断是否有相关账号，没有token返回空
        if(null == userMapper.getUserByNP(username, password)){ //可能不是null而是“null”
            hs.put("token",null);
            return objectMapper.writeValueAsString(hs);
        }
        //生成登录类
        LoginUser loginUser=new LoginUser();
        loginUser.setUserName(username);
        loginUser.setPassword(password);
        //生成token并封装
        String token= TokenUtil.sign(loginUser);
        hs.put("token",token);
        return objectMapper.writeValueAsString(hs);
    }


    @PostMapping("/token")
    @ResponseBody
    @ApiOperation(value = "token测试",notes = "token测试")
    public boolean token(String token) throws JsonProcessingException {
        if(TokenUtil.verify(token)) return true;
        else return false;
    }

}
