package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.CategoryDO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: TextSettingsDAO.java, v 0.1 2018/3/20 10:09 wb-ny291824 Exp $
 */
@Repository
public interface CategoryDAO {

    /**
     * 增加(所有属性)
     *
     * @param record
     * @return
     */
    int insert(CategoryDO record);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    CategoryDO selectByPrimaryKey(Long id);

    /**
     * 根据属性查询
     *
     * @param record
     * @return
     */
    CategoryDO selectSelective(CategoryDO record);

    /**
     * 查询所有记录，带分页
     *
     * @param record
     * @return
     */
    List<CategoryDO> selectByCondition(CategoryDO record);

    /**
     * 根据id更新不为空的字段
     *
     * @param record record
     * @return
     */
    int updateByPrimaryKeySelective(CategoryDO record);

    /**
     * 删除
     *
     * @param id id
     * @return
     */
    int deleteByPrimaryKey(Long id);
}
