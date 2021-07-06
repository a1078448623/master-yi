package com.wuyan.masteryi.mall.config;
/*
 *project:master-yi
 *file:SwaggerConfig
 *@author:wsn
 *date:2021/7/6 12:32
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    Boolean swaggerEnabled=true;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.wuyan.masteryi.mall.controller"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Master YI 后端接口文档")
                .description("所有参数均为必填项，100表示错误/否/没有，200表示正常/有，响应实例暂时没有")
                // 作者信息
                .contact(new Contact("赵书庆、王世宁", "个人主页url", "email"))
                .version("2.0.0")
                .build();
    }
}
