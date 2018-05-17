package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.TagDO;
import org.springframework.stereotype.Repository;

/**
 * 文章标签
 *
 * @author wb-ny291824
 * @version $Id: TagDAO.java, v 0.1 2018/3/26 10:18 wb-ny291824 Exp $
 */
@Repository
public interface TagDAO {

    /**
     * 根据主键删除
     * @param id id
     * @return int
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
     * @return int
     */
    int insert(TagDO record);

    /**
     * 根据主键查找
     * @param id id
     * @return TagDO
     */
    TagDO selectByPrimaryKey(Long id);

    /**
     * 根据属性更新
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(TagDO record);

    /**
     * 条件查找
     * @param record record
     * @return List<TagDO>
     */
    List<TagDO> selectByCondition(TagDO record);

    /**
     * 批量新增
     * @param tagDOS records
     * @return 影响条数
     */
    int insertBatch(List<TagDO> tagDOS);
}