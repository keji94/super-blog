package com.keji.blog.dao;

import com.keji.blog.dataobject.CommentsDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: CommentsDAO.java, v 0.1 2018/3/27 11:52 wb-ny291824 Exp $
 */
@Repository
public interface CommentsDAO {

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
    int insert(CommentsDO record);

    /**
     * 主键查找
     * @param id id
     * @return CommentsDO
     */
    CommentsDO selectByPrimaryKey(Long id);

    /**
     * 主键更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKeySelective(CommentsDO record);

    /**
     * 更新
     * @param record record
     * @return i
     */
    int updateByPrimaryKeyWithBLOBs(CommentsDO record);

    /**
     * 更新(不更新内容)
     * @param record record
     * @return i
     */
    int updateByPrimaryKey(CommentsDO record);
}