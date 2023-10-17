package com.example.javascriptbootdome01.Security;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName AuthorityRepository                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-12  20:50  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    @Query(value = "select a.* from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username=?1", nativeQuery = true)
    List<Authority> findAuthoritiesByUsername(String username);

}
