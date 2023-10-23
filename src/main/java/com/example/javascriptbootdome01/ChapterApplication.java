//package com.example.javascriptbootdome01;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cache.annotation.EnableCaching;
//
//
///**
// * @BelongsProject: JavaScriptBootDome01  //项目名
// * @BelongsPackage: com.example.javascriptbootdome01.Thymeleaf  //包名
// * @ClassName ChapterApplication                //类名
// * @Author: laozaza                   //作者
// * @CreateTime: 2023-09-23  16:22  //时间
// * @Description: TODO                //类描述
// * @Version: 1.0                     //版本
// */
//@SpringBootApplication//用注解标识的类作为springboot的入口类
//@ServletComponentScan//开启基于注解方式的Servlet组件扫描支持
//@EnableCaching//开启SpringBoot基于注解的缓存管理支持
//public class ChapterApplication extends SpringBootServletInitializer {
//    public static void main(String[] args) {
//        SpringApplication.run(ChapterApplication.class, args);
//    }
//    @Override
//    //程序主类继承SpringBootServletInitializer, 并重写configure()方法
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(ChapterApplication.class);
//    }
//}
