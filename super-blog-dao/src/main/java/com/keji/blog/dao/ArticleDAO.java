package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.bo.ArticleBO;
import com.keji.blog.dataobject.ArticleDO;
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
     * 批量删除
     * @param ids ids
     */
    void deleteBatch(Long[] ids);

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
     * 条件查找
     * @param record record
     * @return List<ArticleBO>
     */
    List<ArticleBO> selectByCondition(ArticleBO record);

    /**
     * 主键诚信
     * @param record record
     * @return i
     */
    int updateByPrimaryKeySelective(ArticleDO record);

    /**
     * 更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKeyWithBLOBs(ArticleDO record);

    /**
     * 主键更新(不含内容)
     * @param record record
     * @return i
     */
    int updateByPrimaryKey(ArticleDO record);
}