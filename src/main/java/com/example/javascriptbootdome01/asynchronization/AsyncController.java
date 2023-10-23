package com.example.javascriptbootdome01.asynchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.asynchronization  //包名
 * @ClassName AsyncController                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-23  19:46  //时间
 **/

/**
 * 异步控制器类，用于处理异步请求
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService myService;

    /**
     * 处理发送短信请求，计算主流程耗时
     *
     * @return 成功消息
     * @throws Exception 异常
     */
    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {
        Long startTime = System.currentTimeMillis();
        myService.sendSMS();
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时： " + (endTime - startTime));
        return "success";
    }

    /**
     * 处理统计请求，包括异步计算从1到1000和从1000到2000的整数总和
     *
     * @return 成功消息
     * @throws Exception 异常
     */
    @GetMapping("/statistics")
    public String statistics() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long startTime = System.currentTimeMillis();

        // 启动异步任务，分别计算1-1000和1000-2000的整数总和
        Future<Integer> futureA = myService.processA();
        Future<Integer> futureB = myService.processB();
        // 等待异步任务完成并汇总结果
        int total = futureA.get() + futureB.get();
        System.out.println("----------------------------");
        System.out.println("异步任务数据统计汇总结果： " + total);
        Long endTime = System.currentTimeMillis();//结束时间（没调用）
        System.out.println("开始执行时间" + sdf.format(new Date(startTime)));
        return "success";
    }
}
