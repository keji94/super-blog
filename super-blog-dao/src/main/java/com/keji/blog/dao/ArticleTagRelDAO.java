package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.ArticleTagRelDO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleTagRelDAO.java, v 0.1 2018/3/26 14:34 wb-ny291824 Exp $
 */
@Repository
public interface ArticleTagRelDAO {

    /**
     * 删除
     * @param id id
     * @return i
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增
     * @param record record
     * @return i
     */
    int insert(ArticleTagRelDO record);

    /**
     * 批量新增
     * @param list list
     */
    void insertBatch(List<ArticleTagRelDO> list);

    /**
     * 根据主键查询
     * @param id id
     * @return ArticleTagRelDO
     */
    ArticleTagRelDO selectByPrimaryKey(Long id);

    /**
     * 条件查询
     * @param record record
     * @return List<ArticleTagRelDO>
     */
    List<ArticleTagRelDO> selectByCondition(ArticleTagRelDO record);

    /**
     * 更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKeySelective(ArticleTagRelDO record);

    /**
     * 更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKey(ArticleTagRelDO record);

    /**
     * 根据文章ID批量查询
     *
     * @param articleIds
     * @return
     */
    List<ArticleTagRelDO> selectByArticleIds(List<Long> articleIds);
}