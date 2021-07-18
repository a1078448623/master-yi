//package com.wuyan.masteryi.admin.config;
//
//import com.wuyan.masteryi.admin.realm.UserRealm;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        Map<String,String> filtermap=new LinkedHashMap<>();
//        filtermap.put("/login/**","anon");
////        filtermap.put("/goods","anon");
//        filtermap.put("/goods/**","anon");
////        filtermap.put("/static/**","anon");
////        filtermap.put("/category/**","anon");
////        filtermap.put("/order/**","authc");
////        filtermap.put("/seckill/**","perms[admin]");
//        filtermap.put("/**","authc");
//        System.out.println("8888888888");
////        filtermap.put("/**","authc");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
//        shiroFilterFactoryBean.setUnauthorizedUrl("/login/unauthorized");
//        shiroFilterFactoryBean.setLoginUrl("/login/unlogin");
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm,
//                                                                  @Qualifier("session") DefaultWebSessionManager defaultWebSessionManager){
//        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        defaultWebSecurityManager.setRealm(userRealm);
//        defaultWebSecurityManager.setSessionManager(defaultWebSessionManager);
//        return defaultWebSecurityManager;
//    }
//    @Bean(name = "session")
//    public DefaultWebSessionManager defaultWebSessionManager(){
//        DefaultWebSessionManager defaultWebSessionManager= new DefaultWebSessionManager();
//        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
//        return defaultWebSessionManager;
//    }
//
//    @Bean
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }
//
//    @Bean
//    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
//
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
//        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
//
//        return defaultAdvisorAutoProxyCreator;
//    }
//}
//
//
//
