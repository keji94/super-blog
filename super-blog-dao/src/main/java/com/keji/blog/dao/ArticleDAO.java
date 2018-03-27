package com.keji.blog.dao;

import com.keji.blog.dataobject.ArticleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleDAO.java, v 0.1 2018/3/27 11:46 wb-ny291824 Exp $
 */
@Repository
public interface ArticleDAO {
    /**
     * 主键删除
     * @param id id
     * @return i
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     * @param record record
     * @return i
     */
    int insert(ArticleDO record);

    /**
     * 主键查找
     * @param id id
     * @return ArticleDO
     */
    ArticleDO selectByPrimaryKey(Long id);

    /**
     * 主键诚信
     * @param record record
     * @return i
     */
    int updateByPrimaryKeySelective(ArticleDO record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(ArticleDO record);

    /**
     * 主键更新(不含内容)
     * @param record record
     * @return i
     */
    int updateByPrimaryKey(ArticleDO record);
}