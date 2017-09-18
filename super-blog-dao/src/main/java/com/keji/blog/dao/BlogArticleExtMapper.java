package com.keji.blog.dao;

import com.keji.blog.dataobject.BlogArticleExt;
import com.keji.blog.dataobject.BlogArticleExtExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogArticleExtMapper {
    int countByExample(BlogArticleExtExample example);

    int deleteByExample(BlogArticleExtExample example);

    int deleteByPrimaryKey(Long extId);

    int insert(BlogArticleExt record);

    int insertSelective(BlogArticleExt record);

    List<BlogArticleExt> selectByExample(BlogArticleExtExample example);

    BlogArticleExt selectByPrimaryKey(Long extId);

    int updateByExampleSelective(@Param("record") BlogArticleExt record, @Param("example") BlogArticleExtExample example);

    int updateByExample(@Param("record") BlogArticleExt record, @Param("example") BlogArticleExtExample example);

    int updateByPrimaryKeySelective(BlogArticleExt record);

    int updateByPrimaryKey(BlogArticleExt record);
}