package com.example.javascriptbootdome01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;


/**
 * @BelongsProject: JavaScriptBootDome01  //��Ŀ��
 * @BelongsPackage: com.example.javascriptbootdome01.Thymeleaf  //����
 * @ClassName ChapterApplication                //����
 * @Author: laozaza                   //����
 * @CreateTime: 2023-09-23  16:22  //ʱ��
 * @Description: TODO                //������
 * @Version: 1.0                     //�汾
 */
@SpringBootApplication//��ע���ʶ������Ϊspringboot�������
@ServletComponentScan//��������ע�ⷽʽ��Servlet���ɨ��֧��
@EnableCaching//����SpringBoot����ע��Ļ������֧��
public class ChapterApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
    }
    @Override
    //��������̳�SpringBootServletInitializer, ����дconfigure()����
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ChapterApplication.class);
    }
}
