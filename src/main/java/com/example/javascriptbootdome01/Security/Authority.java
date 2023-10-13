package com.example.javascriptbootdome01.Security;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName Authority                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-12  20:41  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@Entity(name = "t_authority")//设置ORM实体类，并指定映射的表名
public class Authority implements Serializable {
    @Id //表明映射对应的主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //设置主键自增策略
    private Integer id;
    private String authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}