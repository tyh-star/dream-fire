package com.ht.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Docket docket() {
        // 设置显示的swagger环境信息
        // 判断是否处在自己设定的环境当中

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("分组名称")  // 配置api文档的分组
                .enable(true)  // 配置是否开启swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ht")) //配置扫描路径
                .paths(PathSelectors.any()) // 配置过滤哪些
                .build();
    }
    // api基本信息
    private ApiInfo apiInfo() {
        return new ApiInfo("aaa's swagger",
                "测试swagger-ui",
                "v1.0",
                "http://mail.qq.com",
                new Contact("aaa", "http://mail.qq.com", "111@qq.com"),  //作者信息
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}