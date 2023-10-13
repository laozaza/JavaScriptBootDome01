package com.example.javascriptbootdome01.MVC;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/*
 * 自定义一个拦截器类
 * */
@Configuration
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用户请求/admin开头路径,判断用户是否登录
        String uri = request.getRequestURI();
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (uri.startsWith("/admin") && null == loginUser) {
            response.sendRedirect("/toLoginPage");
            return false;
       }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //向request域中存放当前年份用于页面动态展示
        request.setAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        request.setAttribute("currentMonth", Calendar.getInstance().get(Calendar.MONTH));
        request.setAttribute("currentDay", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        request.setAttribute("currentHour", Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        request.setAttribute("currentMinute", Calendar.getInstance().get(Calendar.MINUTE));
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
