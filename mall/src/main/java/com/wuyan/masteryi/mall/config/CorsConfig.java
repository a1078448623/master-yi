package com.wuyan.masteryi.mall.config;
/*
 *project:JavaCode
 *file:CorsConfig
 *@author:wsn
 *date:2021/7/3 11:56
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true) .maxAge(3600) .allowedHeaders("*");
    }
}
