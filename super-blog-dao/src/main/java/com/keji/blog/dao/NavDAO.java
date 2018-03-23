package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.NavDO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: NavDAO.java, v 0.1 2018/3/22 16:50 wb-ny291824 Exp $
 */
@Repository("navDAO")
public interface NavDAO {

    /**
     * 新增
     * @param record record
     * @return i
     */
    int insert(NavDO record);

    /**
     * 根据id查询
     *
     * @param id id
     * @return NavDO
     */
    NavDO selectByPrimaryKey(Long id);

    /**
     * 查询所有记录，带分页
     *
     * @param record record
     * @return List<NavDO>
     */
    List<NavDO> selectByCondition(NavDO record);

    /**
     * 根据id更新不为空的字段
     *
     * @param record record
     * @return i
     */
    int updateByPrimaryKeySelective(NavDO record);

    /**
     * 删除
     *
     * @param id id
     * @return i
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 批量删除
     * @param ids ids
     */
    void deleteBatch(Long[] ids);
}