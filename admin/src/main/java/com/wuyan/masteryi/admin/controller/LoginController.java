package com.wuyan.masteryi.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuyan.masteryi.admin.entity.LoginUser;
import com.wuyan.masteryi.admin.service.UserService;
import com.wuyan.masteryi.admin.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
@Api(tags = "登录接口")
public class LoginController {
    //    @Autowired
//    UserMapper userMapper;
    @Autowired
    UserService userService;

    @PostMapping("/comfirm")
    @ResponseBody
    @ApiOperation(value = "登录测试",notes = "登录测试")
    public String login(String username, String password, HttpServletResponse response, HttpServletRequest request) throws JsonProcessingException {
        HashMap<String,Object> hs=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        //判断是否有相关账号，没有token返回空
        if(null == userService.getUserByNP(username, password)){ //可能不是null而是“null”
            hs.put("token",null);
            return objectMapper.writeValueAsString(hs);
        }
//        Cookie cookie1 = new Cookie("token","");
//        cookie1.setMaxAge(0); //设置立即删除
//        cookie1.setPath("/");
//        response.addCookie(cookie1);

        //生成登录类
        LoginUser loginUser=new LoginUser();
        loginUser.setUserId(userService.getUserId(username));
        loginUser.setUserName(username);
        loginUser.setPassword(password);

        //生成token并封装
        String token= TokenUtil.sign(loginUser);
        System.out.println(token);
        // 创建一个 cookie对象
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(10*60*60*1000);
        String contextPath  = request.getContextPath();
        if(contextPath.trim().equals("")){
            contextPath = "/";
        }
        cookie.setPath(contextPath);
        //将cookie对象加入response响应
        response.addCookie(cookie);

        System.out.println("登录通过");
        hs.put("token",token);
        return objectMapper.writeValueAsString(hs);
    }


    @PostMapping("/token")
    @ResponseBody
    @ApiOperation(value = "token测试",notes = "token测试")
    public boolean token(@RequestHeader("token")String token) throws JsonProcessingException {
        System.out.println(token);
        if(TokenUtil.verify(token)) return true;
        else return false;
    }

    @PostMapping("/logoff")
    @ResponseBody
    @ApiOperation(value = "登出",notes = "登出")
    public String logout(HttpServletRequest request,HttpServletResponse response)throws JsonProcessingException {

        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        String contextPath  = request.getContextPath();
        if(contextPath.trim().equals("")){
            contextPath = "/";
        }

        HashMap<String,Object> hs=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        cookie.setPath(contextPath);

        //将cookie对象加入response响应
        response.addCookie(cookie);
        System.out.println("已登出");
        hs.put("token","");
        return objectMapper.writeValueAsString(hs);
    }

}
