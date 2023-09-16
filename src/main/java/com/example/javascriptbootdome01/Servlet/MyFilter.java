package com.example.javascriptbootdome01.Servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
 * 自定义Filter类
 * */
@WebFilter(value = {"/antionLogin","/antionMyFilter"})//映射“/antionLogin”和“/antionMyFilter”请求的Filter类
//@Component// 标注Spring管理的Bean，使用@Component注解在一个类上，表示将此类标记为Spring容器中的一个Bean。
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello MyFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
