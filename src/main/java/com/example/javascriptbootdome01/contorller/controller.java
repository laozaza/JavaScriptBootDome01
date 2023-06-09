package com.example.javascriptbootdome01.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    //定义HTTP GET请求的URL路径
    @GetMapping("/hlleo")
    public String hello(){
        return "hello";
    }
}
