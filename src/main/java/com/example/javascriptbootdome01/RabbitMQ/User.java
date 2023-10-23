package com.example.javascriptbootdome01.RabbitMQ;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.RabbitMQ  //包名
 * @ClassName qe                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-23  16:58  //时间
 **/
public class User {
    private Integer id;
    private String username;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
