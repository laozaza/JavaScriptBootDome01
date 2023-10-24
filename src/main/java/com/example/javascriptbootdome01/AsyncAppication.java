package com.example.javascriptbootdome01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01  //包名
 * @ClassName AsyncAppication                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-23  19:44  //时间
 **/
@EnableAsync// 启用异步方法支持
@EnableScheduling//启用定时任务支持
@SpringBootApplication
public class AsyncAppication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncAppication.class, args);
    }


}
