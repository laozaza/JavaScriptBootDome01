package com.example.javascriptbootdome01.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName RedisSecurityConfig                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-12  23:04  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@EnableWebSecurity
public class RedisSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServicelmpl userDetailsServicelmpl;
    @Autowired
    private DataSource dataSource;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        选择定义密码加密算法
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


//        内存认证使用这个密码加密
//        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
//                注册一个身份，并且密码需要加密
//                .withUser("GRAB").password(bCryptPasswordEncoder.encode("grab")).roles("common")
//                .and()
//                .withUser("管子").password(bCryptPasswordEncoder.encode("tube")).roles("vip");



//        使用JDBC认证
//        查询客户
        //使用JBDC进行身份认证
//        String userSQL = "select username,password,valid from t_customer " +
//                "where username = ?";
//        String authoritySQL = "select c.username,a.authority from t_customer c,t_authority a," +
//                "t_customer_authority ca where ca.customer_id=c.id " +
//                "and ca.authority_id=a.id and c.username =?";
//        auth.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery(userSQL)
//                .authoritiesByUsernameQuery(authoritySQL);



//        使用UserDetailsServicelmpl进行身份验证
        auth.userDetailsService(userDetailsServicelmpl).passwordEncoder(bCryptPasswordEncoder);
    }
}
