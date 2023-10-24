package com.example.javascriptbootdome01.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Email  //包名
 * @ClassName ad                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-24  22:47  //时间
 **/

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSenderImpl mailSender; // 自动注入邮件发送器
    @Value("${spring.mail.username}")
    private String from; // 从配置文件中读取发件人邮箱地址

    /**
     * 发送纯文本邮件
     * @param to       收件人地址
     * @param subject  邮件标题
     * @param text     邮件内容
     */
    public void sendSimpleEmail(String to, String subject, String text) {
        // 创建纯文本邮件信息对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 设置发件人
        message.setTo(to); // 设置收件人
        message.setSubject(subject); // 设置邮件标题
        message.setText(text); // 设置邮件内容
        try {
            // 发送邮件
            mailSender.send(message);
            System.out.println("纯文本邮件发送成功");
        } catch (MailException e) {
            System.out.println("纯文本邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送复杂邮件（包括静态资源和附件）
     * @param to           收件人地址
     * @param subject      邮件标题
     * @param text         邮件内容
     * @param filePath     附件地址
     * @param rscId        静态资源唯一标识
     * @param rscPath      静态资源地址
     */
    public void sendComplexEmail(String to, String subject, String text, String filePath, String rscId, String rscPath) {
        // 创建复杂邮件信息对象 MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用 MimeMessageHelper 帮助类，设置 multipart 多部分使用为 true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from); // 设置发件人
            helper.setTo(to); // 设置收件人
            helper.setSubject(subject); // 设置邮件标题
            helper.setText(text, true); // 设置邮件内容，允许 HTML 内容
            // 设置邮件静态资源（图片等）
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            // 设置邮件附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            // 发送邮件
            mailSender.send(message);
            System.out.println("复杂邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("复杂邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }
    }

    //单独发送图片的方法
    public void sendComplexEmailImg(String to, String subject, String text, String rscId, String rscPath) {
        // 创建复杂邮件信息对象 MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用 MimeMessageHelper 帮助类，设置 multipart 多部分使用为 true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from); // 设置发件人
            helper.setTo(to); // 设置收件人
            helper.setSubject(subject); // 设置邮件标题
            helper.setText(text, true); // 设置邮件内容，允许 HTML 内容（未调用）
            // 设置邮件静态资源（图片等）
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            // 发送邮件
            mailSender.send(message);
            System.out.println("单独发送图片邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("单独发送图片邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }
    }

    //单独发送附件的方法
    public void sendComplexEmailFile(String to, String subject, String text, String filePath) {
        // 创建复杂邮件信息对象 MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用 MimeMessageHelper 帮助类，设置 multipart 多部分使用为 true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from); // 设置发件人
            helper.setTo(to); // 设置收件人
            helper.setSubject(subject); // 设置邮件标题
            helper.setText(text, true); // 设置邮件内容，允许 HTML 内容
            // 设置邮件附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            // 发送邮件
            mailSender.send(message);
            System.out.println("复杂邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("复杂邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送模板邮件
     * @param to       收件人地址
     * @param subject  邮件标题
     * @param content  邮件内容
     */
    public void sendTemplateEmail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            // 使用 MimeMessageHelper 帮助类，设置 multipart 多部分使用为 true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from); // 设置发件人
            helper.setTo(to); // 设置收件人
            helper.setSubject(subject); // 设置邮件标题
            helper.setText(content, true); // 设置邮件内容，允许 HTML 内容
            // 发送邮件
            mailSender.send(message);
            System.out.println("模板邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("模板邮件发送失败 " + e.getMessage());
            e.printStackTrace();
        }
    }
}
