package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.ArticleImageDO;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * article_image 表的java client
 * 
 * @author : keji
 * @since : 2018-09-21
 */
public interface ArticleImageDAO {
    /**
     *  根据主键删除数据库的记录
     *
     * @param id
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int insert(ArticleImageDO record);

    /**
     *  动态字段,写入数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int insertSelective(ArticleImageDO record);

    /**
     *  根据指定主键获取一条数据库记录
     *
     * @param id
     * @return 实体
     */
    ArticleImageDO selectByPrimaryKey(Long id);

    /**
     *  根据指定主键获取一条被标记删除的数据库记录test
     *
     * @param id
     * @return 实体
     */
    ArticleImageDO selectDeleteByPk(Long id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(ArticleImageDO record);

    /**
     *  根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKey(ArticleImageDO record);

    /**
     * 根据文章id查询
     *
     * @param articleId 文章id
     * @return List<ArticleImageDO>
     */
    List<ArticleImageDO> selectByArticleId(Long articleId);
}