package com.keji.blog.dao;

import com.keji.blog.dataobject.BlogComments;
import com.keji.blog.dataobject.BlogCommentsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogCommentsMapper {
    int countByExample(BlogCommentsExample example);

    int deleteByExample(BlogCommentsExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(BlogComments record);

    int insertSelective(BlogComments record);

    List<BlogComments> selectByExampleWithBLOBs(BlogCommentsExample example);

    List<BlogComments> selectByExample(BlogCommentsExample example);

    BlogComments selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("record") BlogComments record, @Param("example") BlogCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogComments record, @Param("example") BlogCommentsExample example);

    int updateByExample(@Param("record") BlogComments record, @Param("example") BlogCommentsExample example);

    int updateByPrimaryKeySelective(BlogComments record);

    int updateByPrimaryKeyWithBLOBs(BlogComments record);

    int updateByPrimaryKey(BlogComments record);
}