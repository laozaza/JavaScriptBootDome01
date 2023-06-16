package com.example.javascriptbootdome01.ShujuFanhui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component//标识当前类是自定义配置类
public class Person {
    @Value("${student.id}")
    private int id;
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
