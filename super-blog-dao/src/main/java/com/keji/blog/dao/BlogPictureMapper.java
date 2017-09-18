package com.keji.blog.dao;

import com.keji.blog.dataobject.BlogPicture;
import com.keji.blog.dataobject.BlogPictureExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPictureMapper {
    int countByExample(BlogPictureExample example);

    int deleteByExample(BlogPictureExample example);

    int deleteByPrimaryKey(Long pictureId);

    int insert(BlogPicture record);

    int insertSelective(BlogPicture record);

    List<BlogPicture> selectByExample(BlogPictureExample example);

    BlogPicture selectByPrimaryKey(Long pictureId);

    int updateByExampleSelective(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByExample(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByPrimaryKeySelective(BlogPicture record);

    int updateByPrimaryKey(BlogPicture record);
}