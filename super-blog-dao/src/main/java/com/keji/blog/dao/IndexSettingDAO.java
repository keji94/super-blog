package com.keji.blog.dao;

import com.keji.blog.dataobject.IndexSettingDO;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * index_setting 表的java client
 * 
 * @author : keji
 * @since : 2018-09-21
 */
@Repository
public interface IndexSettingDAO {
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
    int insert(IndexSettingDO record);

    /**
     *  动态字段,写入数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int insertSelective(IndexSettingDO record);

    /**
     *  根据指定主键获取一条数据库记录
     *
     * @param id
     * @return 实体
     */
    IndexSettingDO selectByPrimaryKey(Long id);

    /**
     *  根据指定主键获取一条被标记删除的数据库记录test
     *
     * @param id
     * @return 实体
     */
    IndexSettingDO selectDeleteByPk(Long id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(IndexSettingDO record);

    /**
     *  根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKey(IndexSettingDO record);
}