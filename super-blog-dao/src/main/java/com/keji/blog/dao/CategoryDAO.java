package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.CategoryDO;
import org.springframework.stereotype.Repository;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsDAO.java, v 0.1 2018/3/20 10:09 wb-ny291824 Exp $
 */
@Repository
public interface CategoryDAO {

    /**
     * 增加(所有属性)
     *
     * @param record record
     * @return 影响条数
     */
    int insert(CategoryDO record);

    /**
     * 根据id查询
     *
     * @param id id
     * @return 影响条数
     */
    CategoryDO selectByPrimaryKey(Long id);

    /**
     * 根据属性查询
     *
     * @param record record
     * @return 影响条数
     */
    CategoryDO selectSelective(CategoryDO record);

    /**
     * 查询所有记录，带分页
     *
     * @param record record
     * @return 影响条数
     */
    List<CategoryDO> selectByCondition(CategoryDO record);

    /**
     * 根据id更新不为空的字段
     *
     * @param record record
     * @return 影响条数
     */
    int updateByPrimaryKeySelective(CategoryDO record);

    /**
     * 删除
     *
     * @param id id
     * @return 影响条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据名称查找
     *
     * @param list tagNameS
     * @return List<CategoryDO>
     */
    List<CategoryDO> selectByNameS(List<String> list);

    /**
     * 批量新增
     *
     * @param list list
     * @return 自增主键
     */
    int insertBatch(List<CategoryDO> list);
}
