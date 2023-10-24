package com.example.javascriptbootdome01;


import com.example.javascriptbootdome01.Email.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Email  //包名
 * @ClassName ad                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-24  22:47  //时间
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailApplicationTests {
    @Autowired
    private SendEmailService sendEmailService; // 自动注入邮件发送服务

    @Autowired
    private TemplateEngine templateEngine; // 自动注入模板引擎

    @Test
    public void sendSimpleMailTest() {
        String to = "3078391263@qq.com"; // 收件人地址
        String subject = "纯文本邮件"; // 邮件标题
        String text = "Spring Boot纯文本邮件发送内容测试....."; // 邮件内容
        // 发送简单邮件
        sendEmailService.sendSimpleEmail(to, subject, text);
    }

    @Test
    public void sendComplexEmailAllTest() {
        String to = "3078391263@qq.com"; // 收件人地址
        String subject = "复杂"; // 邮件标题
        // 定义邮件内容
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>祝大家元旦快乐！</h1>");
        // cid为固定写法，rscId指定一个唯一标识
        String rscId = "img001";
        text.append("<img src='cid:" + rscId + "'/></body>");
        text.append("</html>");
        // 指定静态资源文件和附件路径
        String rscPath = "E:\\IDEAWORK\\JavaScriptWork01\\JavaScriptBootDome01\\src\\main\\resources\\static\\login\\file\\newyear.jpg";
        String filePath = "E:\\IDEAWORK\\JavaScriptWork01\\JavaScriptBootDome01\\src\\main\\resources\\static\\login\\file\\元旦放假注意事项.docx";
        // 发送复杂邮件
        sendEmailService.sendComplexEmail(to, subject, text.toString(), filePath, rscId, rscPath);
    }

    //单独发送邮件附件的测试方法
    @Test
    public void sendComplexEmailFileTest() {
        String to = "3078391263@qq.com"; // 收件人地址
        String subject = "单独发送附件"; // 邮件标题
        // 定义邮件内容
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        // cid为固定写法，rscId指定一个唯一标识
        // 指定静态资源文件和附件路径
        String filePath = "E:\\IDEAWORK\\JavaScriptWork01\\JavaScriptBootDome01\\src\\main\\resources\\static\\login\\file\\元旦放假注意事项.docx";
        // 发送复杂邮件
        sendEmailService.sendComplexEmailFile(to, subject, text.toString(), filePath);
    }

    //单独发送邮件图片的测试方法
    @Test
    public void sendComplexEmailImgTest() {
        String to = "3078391263@qq.com"; // 收件人地址
        String subject = "单独发送图片 标题"; // 邮件标题
        // 定义邮件内容
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        // cid为固定写法，rscId指定一个唯一标识
        String rscId = "img001";
        text.append("<img src='cid:" + rscId + "'/></body>");
        text.append("</html>");
        // 指定静态资源文件和附件路径
        String rscPath = "E:\\IDEAWORK\\JavaScriptWork01\\JavaScriptBootDome01\\src\\main\\resources\\static\\login\\file\\newyear.jpg";
        // 发送复杂邮件
        sendEmailService.sendComplexEmailImg(to, subject, text.toString(),rscId, rscPath);
    }

    @Test
    public void sendTemplateEmailTest() {
        String to = "3078391263@qq.com"; // 收件人地址
        String subject = "模板邮件，标题"; // 邮件标题
        // 使用模板邮件定制邮件正文内容
        Context context = new Context();
        context.setVariable("username", "石头"); // 设置模板变量 username
        context.setVariable("code", "456123"); // 设置模板变量 code
        // 使用TemplateEngine设置要处理的模板页面
        String emailContent = templateEngine.process("email/emailTemplate_vercode", context);
        // 发送模板邮件
        sendEmailService.sendTemplateEmail(to, subject, emailContent);
    }
}

