package com.example.javascriptbootdome01.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 *@BelongsProject: JavaScriptBootDome01  //项目名
 *@BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 *@ClassName CustomerService                //类名
 *@Author: laozaza                   //作者
 *@CreateTime: 2023-10-12  19:59  //时间
 *@Description: TODO                //类描述
 *@Version: 1.0                     //版本
*/
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private RedisTemplate redisTemplate;


    //    用户名查询用户
    public Customer getCustomer(String username) {
        Customer customer = null;
        Object o = redisTemplate.opsForValue().get("customer_" + username);
        if (o != null) {
            customer = (Customer) o;
        } else {
            customer = customerRepository.findByUsername(username);
            if (customer != null) {
                redisTemplate.opsForValue().set("customer_" + username, customer);
            }
        }
        return customer;
    }

    //业务控制：使用唯一用户权限
    public List<Authority> getCustomerAuthority(String username) {
        List<Authority> authorities = null;
        Object o = redisTemplate.opsForValue().get("authorities_" + username);
        if (o != null) {
            authorities = (List<Authority>) o;
        } else {
            authorities = authorityRepository.findAuthoritiesByUsername(username);
            if (authorities.size() > 0) {
                redisTemplate.opsForValue().set("authorities_" + username, authorities);
            }
        }
        return authorities;
    }
}
