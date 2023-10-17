package com.example.javascriptbootdome01.Security;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName Customer                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-12  20:04  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@Entity(name = "t_customer")//设置ORM实体类，并指定映射的表名
public class Customer implements Serializable {
    @Id //表明映射对应的主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //设置主键自增策略
    @Column(name = "id") //指定映射的表名字段
    private Integer id;
    private String username;
    private String password;
    private byte valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getValid() {
        return valid;
    }

    public void setValid(byte valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", valid=" + valid +
                '}';
    }
}
