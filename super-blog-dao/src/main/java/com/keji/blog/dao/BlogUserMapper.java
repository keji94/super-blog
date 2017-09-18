package com.keji.blog.dao;

import com.keji.blog.dataobject.BlogUser;
import com.keji.blog.dataobject.BlogUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogUserMapper {
    int countByExample(BlogUserExample example);

    int deleteByExample(BlogUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    List<BlogUser> selectByExample(BlogUserExample example);

    BlogUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByExample(@Param("record") BlogUser record, @Param("example") BlogUserExample example);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}