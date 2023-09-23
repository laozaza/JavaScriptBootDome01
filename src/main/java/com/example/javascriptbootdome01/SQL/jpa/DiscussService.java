package com.example.javascriptbootdome01.SQL.jpa;

import org.springframework.beans.factory.annotation.Autowired;
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
@Service
public class DiscussService {
    @Autowired
    private DiscussRepository discussRepository;
    public Discuss findById(int commet_id){
        Optional<Discuss> optional = discussRepository.findById(commet_id);
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
