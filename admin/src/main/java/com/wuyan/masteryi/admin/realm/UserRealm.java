//package com.wuyan.masteryi.admin.realm;
//
//import com.wuyan.masteryi.admin.entity.User;
//import com.wuyan.masteryi.admin.mapper.UserMapper;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UserRealm extends AuthorizingRealm {
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Subject subject= SecurityUtils.getSubject();
//        User currentUser = (User) subject.getPrincipal();
//        if("admin".equals(currentUser.getUserName())){
//            info.addStringPermission("admin");
//        }
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        User user = userMapper.getUserByNP(token.getUsername());
//        System.out.println("认证中");
//        if(user==null) return null;
//        return new SimpleAuthenticationInfo(user,user.getUserPwd(),"");
//
//    }
//
//}
