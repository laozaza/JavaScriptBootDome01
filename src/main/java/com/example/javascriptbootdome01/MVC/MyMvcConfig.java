package com.example.javascriptbootdome01.MVC;



import com.example.javascriptbootdome01.Thymeleaf.MyLocalResovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
实现WebMvcConfigurer接口,用于对MVC框架功能扩展
*/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResovel();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //请求toLoginPage映射路径或者logi.html页面都会自动映射到login.html页面
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }
    @Autowired
    private MyInterceptor myInterceptor;
    //添加拦截器管理
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")//拦截所有路径请求
                .excludePathPatterns("/login.html");//路径请求放行处理
    }

}


