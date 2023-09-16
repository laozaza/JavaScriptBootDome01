package com.example.javascriptbootdome01.Thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
实现WebMvcConfigurer接口,用于对MVC框架功能扩展
*/
@Configuration
public class MyMvcConfig {
    //自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }
}


