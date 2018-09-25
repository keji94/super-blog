package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.bo.ArticleBO;
import com.keji.blog.dataobject.ArticleDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wb-ny291824
 * @version $Id: ArticleDAO.java, v 0.1 2018/3/27 11:46 wb-ny291824 Exp $
 */
@Repository
public interface ArticleDAO {
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
    int insert(ArticleDO record);

    /**
     *  动态字段,写入数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int insertSelective(ArticleDO record);

    /**
     *  根据指定主键获取一条数据库记录
     *
     * @param id 主键
     * @return 实体
     */
    ArticleDO selectByPrimaryKey(Long id);

    /**
     * 查询文章
     *
     * @param title 标题
     * @param id 主键
     * @return  List<ArticleBO>
     */
    List<ArticleBO> selectWithBlobs(@Param("title") String title,@Param("id") Long id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(ArticleDO record);

    /**
     *  根据主键来更新符合条件的数据库记录
     *
     * @param record 实体对象
     * @return 影响行数
     */
    int updateByPrimaryKey(ArticleDO record);

    /**
     * 批量删除文章id
     *
     * @param ids ids
     */
    void deleteBatch(Long[] ids);
}