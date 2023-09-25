package com.example.javascriptbootdome01.SQL.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.SQL.jpa  //包名
 * @ClassName jih                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-09-23  11:04  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */

@RestController
public class JpaController {
    @Autowired
    private DiscussRepository discussRepository;
    @Autowired
    private DiscussService discussService;

    @GetMapping("/get/{id}")
    public Discuss findById(@PathVariable("id") int comment_id) {
        Discuss discuss = discussService.findById(comment_id);
        return discuss;
    }

    @GetMapping("/update/{id}/{author}")
    public Discuss updateDiscuss(@PathVariable("id") int comment_id,
                                 @PathVariable("author") String author) {
        Discuss discuss = discussService.findById(comment_id);
        discuss.setAuthor(author);
        Discuss updateDiscuss = discussService.updateDiscuss(discuss);
        return updateDiscuss;
    }

    @GetMapping("/delete/{id}")
    public void deletaDiscuss(@PathVariable("id") int comment_id) {
        discussService.deleteDiscuss(comment_id);
    }
}
