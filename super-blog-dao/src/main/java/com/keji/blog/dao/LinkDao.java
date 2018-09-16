package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.bo.LinkBO;
import com.keji.blog.dataobject.LinkDO;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * link 表的java client
 * 
 * @author : Administrator
 * @since : 2018-09-16
 */
public interface LinkDao {
    /**
     *  根据主键删除数据库的记录
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int insert(LinkDO record);

    /**
     *  动态字段,写入数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int insertSelective(LinkDO record);

    /**
     *  根据指定主键获取一条数据库记录
     *
     * @param id 主键
     * @return 实体
     */
    LinkDO selectByPrimaryKey(Long id);

    /**
     *  根据指定主键获取一条被标记删除的数据库记录test
     *
     * @param id 主键
     * @return 实体
     */
    LinkDO selectDeleteByPk(Long id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(LinkDO record);

    /**
     *  根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKey(LinkDO record);

    /**
     * 按categoryName查找所有link
     *
     * @return List<LinkBO>
     */
    List<LinkBO> listAll();
}