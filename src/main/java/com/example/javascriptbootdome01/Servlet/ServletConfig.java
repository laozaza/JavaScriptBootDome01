package com.example.javascriptbootdome01.Servlet;

import org.springframework.context.annotation.Configuration;
/*
 * 嵌入式servlet容器三大组件配置(对MyServlet相关组件进行注册)
 * */

@Configuration//标识当前类是自定义配置类
public class ServletConfig {
    //注册 servlet组件（用来处理客户端请求的动态资源，也就是当我们在浏览器中键入一个地址回车跳转后，请求就会被发送到对应的Servlet上进行处理。）
//    @Bean
//    public ServletRegistrationBean getServlet(MyServlet myServlet) {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(myServlet, "/myServlet");//在浏览器上访问myServlet
//        return registrationBean;
//    }
//
//    //注册Filter组件（主要负责拦截请求，和放行）
//    @Bean
//    public FilterRegistrationBean getFilter(MyFilter filter) {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
//        registrationBean.setUrlPatterns(Arrays.asList("/toLoginPage", "/myFilter"));//在浏览器访问
//        return registrationBean;
//    }
//
//    //注册Listener组件（监听某个事件的发生，状态的改变）
//    @Bean
//    public ServletListenerRegistrationBean getServletListener(MyListener myListener) {
//        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(myListener);
//        return registrationBean;
//    }

}
