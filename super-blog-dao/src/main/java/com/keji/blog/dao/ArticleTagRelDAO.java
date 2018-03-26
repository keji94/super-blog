package com.keji.blog.dao;

import com.keji.blog.dataobject.ArticleTagRelDO;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleTagRelDAO.java, v 0.1 2018/3/26 13:08 wb-ny291824 Exp $
 */
@Mapper
public interface ArticleTagRelDAO {

    /**
     * 删除
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     * @param record record
     * @return int
     */
    int insert(ArticleTagRelDO record);

    /**
     * 根据主键查询
     * @param id id
     * @return ArticleTagRelDO
     */
    ArticleTagRelDO selectByPrimaryKey(Long id);

    /**
     * 更新
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(ArticleTagRelDO record);

    /**
     * 更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKey(ArticleTagRelDO record);
}