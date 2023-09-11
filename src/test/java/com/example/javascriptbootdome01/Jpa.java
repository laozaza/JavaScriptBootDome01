package com.example.javascriptbootdome01;


import com.example.javascriptbootdome01.SQL.jpa.Discuss;
import com.example.javascriptbootdome01.SQL.jpa.DiscussRepository;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpaTest {
    @Autowired
    private DiscussRepository repository;
    @Test
    void Jpa() throws RuntimeException{
       // JPA
        //输出List的全部数据
        List<Discuss> list = repository.findByAuthorNotNull();
       System.out.println(list);

        //使用@Query注解进行数据操作（输出List中的指定aid数据）
        Pageable pageable = PageRequest.of(0,3);
        List<Discuss> allpaged = repository.getDiscussPaged(1,pageable);
        System.out.println(allpaged);

        //使用Example封装参数进行数据查询操作
        Discuss discuss=new Discuss();
        discuss.setAuthor("张三");
        Example<Discuss> example =Example.of(discuss);
        List<Discuss> list1=repository.findAll(example);
        System.out.println(list1);

        Discuss discuss1=new Discuss();
        discuss1.setAuthor("张");
        ExampleMatcher matcher=ExampleMatcher.matching()
                .withMatcher("author",startsWith());
        Example<Discuss> example1=Example.of(discuss1,matcher);
        List<Discuss> list2=repository.findAll(example1);
        System.out.println(list2);

        //使用Jpa Repository内部方法进行数据操作
        System.out.println("-----------------------");
        Optional<Discuss> optional = repository.findById(1);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }
        System.out.println();
    }
}