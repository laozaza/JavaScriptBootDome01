package com.example.javascriptbootdome01.SQL.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.SQL.jpa  //包名
 * @ClassName ArticleService                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-09-25  18:57  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@Service
public class JpaArticleService {
    @Autowired
    private JpaArticleRepository jpaArticleRepository;

    //根据id查询评论信息
    @Cacheable(cacheNames = "article", unless = "#result==null")// 表示查询结果为空不进行缓存,将运行结果缓存，以后查询相同的数据，直接从缓存中取，不需要调用方法。
    public JpaArticle findById2(int article_id) {
        Optional<JpaArticle> optional = jpaArticleRepository.findById(article_id);
        //判断optional是否存在
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @CachePut(cacheNames = "article", key = "#result.id")//将运行结果更新
    public JpaArticle updateJpaArticle(JpaArticle article) {
        jpaArticleRepository.updateJpaArticle(article.getTitle(), article.getId());
        return article;
    }

    @CacheEvict(cacheNames = "article")//将redis服务中的comment删除
    public void deleteJpaArticle(int article_id) {
        jpaArticleRepository.deleteJpaArticle(article_id);
    }

}
