package com.wuyan.masteryi.admin.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import java.util.Map;

public class ShiroUtil {
    static public int verify(AuthenticationToken token){

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            return 1;
        }catch (UnknownAccountException | IncorrectCredentialsException e){
            System.out.println(3);
            return 2; //登录失败
        }
    }
}
