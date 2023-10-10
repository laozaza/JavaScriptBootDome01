//package com.example.javascriptbootdome01.Security;
//
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
///**
// * @BelongsProject: JavaScriptBootDome01  //项目名
// * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
// * @ClassName WebSecurityConfigurerAdapter                //类名
// * @Author: laozaza                   //作者
// * @CreateTime: 2023-10-08  11:50  //时间
// * @Description: TODO                //类描述
// * @Version: 1.0                     //版本
// */
//@EnableWebSecurity//开启MVC Security安全支持
//public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //密码需要设置编码器
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        //使用用户内存信息，作为测试使用
//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("GRAB").password(encoder.encode("grab")).roles("common")
//                .and()
//                .withUser("管子").password(encoder.encode("tube")).roles("vip");
//    }
//}
//
//
