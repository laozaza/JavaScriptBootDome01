package com.example.javascriptbootdome01.HuanJinQieHuan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration//标识当前类是自定义配置类
@Profile("test")
public class TestDBConnector implements DBConnector {
    @Override
    public String config() {
        return "这个是测试环境";
    }
}