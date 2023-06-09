package com.example.javascriptbootdome01;


import com.example.javascriptbootdome01.contorller.controller;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
class JavaScriptBootDome01ApplicationTests {
    @Autowired
    private controller con;
    @Test
    void contextLoads() throws RuntimeException {
        String hello =con.hello();
        System.out.println(hello);
    }
}
