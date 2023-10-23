package com.example.javascriptbootdome01.asynchronization;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.asynchronization  //包名
 * @ClassName AsyncService                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-23  17:00  //时间
 **/
@Service
public class AsyncService {
    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime)); }

    @Async
    public Future<Integer> processA() throws Exception {
        int start = 1;
        int end = 1000;
        int sum = 0;

        // 获取开始时间
        long startTime = System.currentTimeMillis();

        // 计算总和
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        // 打印结果
        System.out.println("从 " + start + " 到 " + end + " 的整数总和是: " + sum);

        // 打印开始时间和结束时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("计算1-1000的值总和开始执行时间: " + sdf.format(new Date(startTime)));

        // 休眠5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取结束时间
        long endTime = System.currentTimeMillis();

        // 打印结束时间
        System.out.println("计算1-1000的值总和结束时间: " + sdf.format(new Date(endTime)));
        return new AsyncResult<Integer>(sum);
    }

    @Async
    public Future<Integer> processB() throws Exception {
        int start = 1000;
        int end = 2000;
        int sum = 0;

        // 获取开始时间
        long startTime = System.currentTimeMillis();

        // 计算总和
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        // 获取结束时间
        long endTime = System.currentTimeMillis();

        // 打印结果
        System.out.println("从 " + start + " 到 " + end + " 的整数总和是: " + sum);

        // 打印开始时间和结束时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("计算1000 - 2000的值总和开始执行时间: " + sdf.format(new Date(startTime)));
        System.out.println("计算1000 - 2000的值总和结束时间: " + sdf.format(new Date(endTime)));
        return new AsyncResult<Integer>(sum);
    }


}
