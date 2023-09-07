package com.example.javascriptbootdome01.SQL;

import org.apache.ibatis.annotations.*;

@Mapper
//注解表示该类是一个MyBatis接口文件，并保证能够被Spring Boot自动扫描到Spring容器中;
// 在接口内部，分别通过@select、@Insert、@Update、@Delete注解配合SOL语句完成了对数据库t_comment数据的增删改查操作
public interface ArticleMapper {
    //查询方法
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public Article findById(Integer id);

    //插入方法
    @Insert("INSERT INTO t_comment(content,author,a_id) " +
            "values (#{content},#{author},#{aId})")
    public int insertArticle(Article article);

    //更新方法
    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateArticle(Article article);

    //删除方法
    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteArticle(Integer id);


}
