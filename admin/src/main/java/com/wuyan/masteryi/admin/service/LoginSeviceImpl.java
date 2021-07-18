//package com.wuyan.masteryi.admin.service;
//
//import com.wuyan.masteryi.admin.entity.User;
//import com.wuyan.masteryi.admin.mapper.UserMapper;
//import com.wuyan.masteryi.admin.utils.ResponseMsg;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
//@Service
//public class LoginSeviceImpl implements LoginService {
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Override
//    public Map<String, Object> login(String username, String password, HttpServletResponse response, HttpServletRequest request) {
//        User user = userMapper.getUserByNP(username);
//
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken atoken = new UsernamePasswordToken(username, password);
//
//        Cookie cookie = new Cookie("token", username);
//        cookie.setMaxAge(10*60*60*1000);
//        String contextPath  = request.getContextPath();
//        if(contextPath.trim().equals("")){
//            contextPath = "/";
//        }
//        cookie.setPath(contextPath);
//        //将cookie对象加入response响应
//        response.addCookie(cookie);
//
////        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//        try {
//            subject.login(atoken);
//            System.out.println(2);
//            return ResponseMsg.sendMsg(200, "登陆成功", 2);
//        }catch (UnknownAccountException | IncorrectCredentialsException e){
//            System.out.println(3);
//            return ResponseMsg.sendMsg(200, "登陆失败", 3); //登录失败
//        }
//    }
//
//
//
//
//}
