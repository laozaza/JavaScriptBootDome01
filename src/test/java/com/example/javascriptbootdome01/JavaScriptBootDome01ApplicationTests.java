package com.example.javascriptbootdome01;


import com.example.javascriptbootdome01.HuanJinQieHuan.DBConnector;
import com.example.javascriptbootdome01.ShujuFanhui.Person;
import com.example.javascriptbootdome01.ShujuFanhui.Student;
import com.example.javascriptbootdome01.ShujuFanhui.User;
import com.example.javascriptbootdome01.contorller.controller;
import com.example.javascriptbootdome01.coustom.CustomProperties;
import com.example.javascriptbootdome01.coustom.MyProperties;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
class JavaScriptBootDome01ApplicationTests {
    @Autowired
    private controller con;
    @Autowired
    Student stu;
    @Autowired
    Person person;
    @Autowired
    User user;
    @Value("${student.id}")
    int id;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    CustomProperties customProperties;
    @Autowired
    DBConnector dbConnector;
    @Test
    void contextLoads() throws RuntimeException {
        String result = con.hello();
        MyProperties myProperties = (MyProperties) applicationContext.getBean("xmlpropertoes");
        if (myProperties != null) {
            myProperties.getResult();
        }
        System.out.println(customProperties);
        System.out.println(dbConnector.config());
    }
}
