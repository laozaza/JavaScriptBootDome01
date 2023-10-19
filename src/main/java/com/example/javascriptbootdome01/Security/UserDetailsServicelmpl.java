package com.example.javascriptbootdome01.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName UserDetailsService                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-12  22:29  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@Service
public class UserDetailsServicelmpl implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        获取用户信息
        Customer customer = customerService.getCustomer(username);
//        customer =customerRepository.findById2(username);
//        System.out.println(customer.getId());


//        获取权限
        List<Authority> authorityList = customerService.getCustomerAuthority(username);
//        信息权限封装
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = authorityList.stream()
                .map(authority -> new SimpleGrantedAuthority(authority
                        .getAuthority())).collect(Collectors.toList());
//       返回的封装的userdatails用户详情类
        if (customer != null) {
            UserDetails userDetails = new User2(customer.getUsername(), customer.getPassword(),customer.getId(),simpleGrantedAuthorityList);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }

    }
}