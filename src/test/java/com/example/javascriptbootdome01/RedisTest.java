package com.example.javascriptbootdome01;


import com.example.javascriptbootdome01.SQL.Redis.Address;
import com.example.javascriptbootdome01.SQL.Redis.Family;
import com.example.javascriptbootdome01.SQL.Redis.Person1;
import com.example.javascriptbootdome01.SQL.Redis.Person1Repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisTest {
    @Autowired
    private Person1Repository repository1;
    static Person1 save;

    @Test
    void Redis() throws RuntimeException {
        //创建并添加住址信息
        Person1 person1 = new Person1("01", "张", "有才");
        Person1 person2 = new Person1("02", "jim", "smeis");
        Address address = new Address("北京", "china");
        person1.setAddress(address);
        //创建并添加家庭成员
        List<Family> list = new ArrayList<>();
        Family dad = new Family("爹", "老登");
        Family mom = new Family("妈", "made");
        list.add(dad);
        list.add(mom);
        person1.setFamilyList(list);
        //向Redis数据库添加数据

        save = repository1.save(person1);
        Person1 save2 = repository1.save(person2);
        //输出数据
        System.out.println(save);
//        System.out.println(save2);

        //选择数据输出
        List<Person1> list3 = repository1.findByAddress_City("北京");
        System.out.println(list3);
        //更新数据
        Person1 person3=repository1.findByFirstnameAndLastname("张","有才").get(0);
        person3.setFirstname("黄");
        Person1 update=repository1.save(person3);
        System.out.println(update);

    }
    @Test
    private void detelePerson(){
        //删除数据
        Person1 person4= repository1.findByFirstnameAndLastname("张","小明").get(0);
        repository1.delete(person4);
    }
}
