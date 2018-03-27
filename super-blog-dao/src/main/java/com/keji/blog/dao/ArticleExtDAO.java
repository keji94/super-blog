package com.keji.blog.dao;

import com.keji.blog.dataobject.ArticleExtDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wb-ny291824
 * @version $Id: ArticleExtDAO.java, v 0.1 2018/3/27 11:51 wb-ny291824 Exp $
 */
@Repository
public interface ArticleExtDAO {
    /**
     * 主键删除
     *
     * @param id id
     * @return i
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     *
     * @param record record
     * @return i
     */
    int insert(ArticleExtDO record);

    /**
     * 主键查找
     *
     * @param id id
     * @return ArticleExtDO
     */
    ArticleExtDO selectByPrimaryKey(Long id);

    /**
     * 更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKeySelective(ArticleExtDO record);

    /**
     * 主键更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKey(ArticleExtDO record);
}