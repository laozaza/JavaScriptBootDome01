package com.example.javascriptbootdome01.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Controller
public class LoginController {
    //定义HTTP GET请求的URL路径
    @GetMapping("/toLoginPage")
    public String toLoginPage(Model model){
        //获取并封装当前年份，跳转到登录页login.html
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
