package com.example.javascriptbootdome01.Scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Scheduled  //包名
 * @ClassName e                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-24  13:50  //时间
 **/
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count1 = 1;
    private Integer count2 = 1;
    private Integer count3 = 1;

    // 使用fixedRate属性，每10秒执行一次任务，任务执行完后休眠5秒
    @Async
    @Scheduled(fixedRate = 10000)
    public void scheduledTaskWithFixedRate() throws InterruptedException {
        System.out.println("fixedRate1执行时间：" + dateFormat.format(new Date()));
        Thread.sleep(5000); // 代码块休眠5秒
    }

//    // 使用fixedRate属性，每15秒执行一次任务，任务执行完后休眠15秒
//    @Async
//    @Scheduled(fixedRate = 15000)
//    public void scheduledTaskWithFixedRate2() throws InterruptedException {
//        System.out.println("fixedRate2每十五秒执行一次");
//        Thread.sleep(15000); // 代码块休眠15秒
//    }
//
//    // 使用fixedDelay属性，10秒后执行任务，之后每10秒执行一次，任务执行完后休眠5秒
//    @Async
//    @Scheduled(fixedDelay = 10000)
//    public void scheduledTaskWithFixedDelay() throws InterruptedException {
//        System.out.println("fixedDelay1执行时间：" + dateFormat.format(new Date()));
//        Thread.sleep(5000); // 代码块休眠5秒
//    }
//
//    // 使用fixedDelay属性，5秒后执行任务，之后每5秒执行一次，任务执行完后休眠5秒
//    @Async
//    @Scheduled(fixedDelay = 5000)
//    public void scheduledTaskWithFixedDelay2() throws InterruptedException {
//        System.out.println("fixedDelay2每五秒执行一次");
//        Thread.sleep(5000); // 代码块休眠5秒
//    }
//
//    // 使用initialDelay属性，初始延迟10秒后执行，之后每10秒执行一次，任务执行完后休眠5秒
//    @Async
//    @Scheduled(initialDelay = 10000, fixedRate = 10000)
//    public void scheduledTaskWithInitialDelay() throws InterruptedException {
//        System.out.println("initialDelay1执行时间：" + dateFormat.format(new Date()));
//        Thread.sleep(5000); // 代码块休眠5秒
//    }
//
//    // 使用initialDelay属性，初始延迟0秒后执行，之后每5秒执行一次，任务执行完后休眠5秒
//    @Async
//    @Scheduled(initialDelay = 0, fixedRate = 5000)
//    public void scheduledTaskWithInitialDelay2() throws InterruptedException {
//        System.out.println("initialDelay2执行时间：" + dateFormat.format(new Date()));
//        Thread.sleep(5000); // 代码块休眠5秒
//    }

    // 使用cron表达式，每分钟执行一次任务
//    @Scheduled(cron = "0 * * * * *")
//    // 秒、分、小时、日、月、星期 MON-FRI表示周一到周五
//    // 0：代表秒，表示在每分钟的第0秒触发任务。
//    // *：代表通配符，表示每分钟都匹配。
//    public void scheduledTaskCron() {
//        System.out.println(String.format("cron第%s次执行，当前时间为：%s", count3++, dateFormat.format(new Date())));
//    }
}

