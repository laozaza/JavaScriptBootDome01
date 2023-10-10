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
 * @ClassName SecurityConfig                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-10  16:35  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@EnableWebSecurity//开启MVC security安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码需要设置编码器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //使用JBDC进行身份认证
        String userSQL = "select username,password,valid from t_customer " +
                "where username = ?";
        String authoritySQL = "select c.username,a.authority from t_customer c,t_authority a," +
                "t_customer_authority ca where ca.customer_id=c.id " +
                "and ca.authority_id=a.id and c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);
    }
}
