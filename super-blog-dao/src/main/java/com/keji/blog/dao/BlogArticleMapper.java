package com.keji.blog.dao;

import com.keji.blog.dataobject.BlogArticle;
import com.keji.blog.dataobject.BlogArticleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogArticleMapper {
    int countByExample(BlogArticleExample example);

    int deleteByExample(BlogArticleExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(BlogArticle record);

    int insertSelective(BlogArticle record);

    List<BlogArticle> selectByExampleWithBLOBs(BlogArticleExample example);

    List<BlogArticle> selectByExample(BlogArticleExample example);

    BlogArticle selectByPrimaryKey(Long articleId);

    int updateByExampleSelective(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByExample(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByPrimaryKeySelective(BlogArticle record);

    int updateByPrimaryKeyWithBLOBs(BlogArticle record);

    int updateByPrimaryKey(BlogArticle record);
}