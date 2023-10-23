package com.example.javascriptbootdome01;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01  //包名
 * @ClassName async                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-23  17:46  //时间
 **/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class AsyncTest {
    @Test
    private void num() {
        int start = 1;
        int end = 1000;
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
        System.out.println("开始执行时间: " + sdf.format(new Date(startTime)));

        // 休眠5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印结束时间
        System.out.println("结束时间: " + sdf.format(new Date(endTime)));
    }

    @Test
    void num2() {
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
        System.out.println("开始执行时间: " + sdf.format(new Date(startTime)));
        System.out.println("结束时间: " + sdf.format(new Date(endTime)));
    }
}



