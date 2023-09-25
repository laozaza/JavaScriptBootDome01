package com.example.javascriptbootdome01.SQL.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.SQL.jpa  //包名
 * @ClassName DIscussService                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-09-23  15:20  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@Service//标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.xml文件定义bean了。
public class DiscussService {
    @Autowired
    private DiscussRepository discussRepository;
    //根据id查询评论信息
    @Cacheable(cacheNames = "discuss")//将运行结果缓存，以后查询相同的数据，直接从缓存中取，不需要调用方法。
    public Discuss findById(int comment_id){
        Optional<Discuss> optional = discussRepository.findById(comment_id);
        //判断optional是否存在
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    public Discuss updateDiscuss(Discuss discuss){
        discussRepository.updateDiscuss(discuss.getAuthor(),discuss.getId());
        return discuss;
    }
    public void deleteDiscuss(int comment_id){
        discussRepository.deleteById(comment_id);
    }


}
