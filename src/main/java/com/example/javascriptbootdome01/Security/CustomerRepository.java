package com.example.javascriptbootdome01.Security;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName CustomerRepository                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-12  20:30  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //    可以直接使用JPA生成的实现
//    @Query(value = "select c.* from t_customer c where c.username=?1", nativeQuery = true)
    Customer findByUsername(String username);
}
