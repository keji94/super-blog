package com.keji.blog.service.admin;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.keji.blog.bo.ArticleBO;
import com.keji.blog.dataobject.ArticleDO;

/**
 * @author wb-ny291824
 * @version $Id: NavService.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
public interface ArticleAdminService {

    /**
     * 查询导航信息
     *
     * @param articleBO 查询条件
     * @param pageIndex 开始页
     * @param pageSize  结束页
     * @return PageInfo<ArticleBO>
     */
    PageInfo<ArticleBO> list(ArticleBO articleBO, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有
     *
     * @param articleBO 条件
     * @return List<ArticleBO>
     */
    List<ArticleBO> listAll(ArticleBO articleBO);

    /**
     * 更新
     *
     * @param articleDO articleDO
     * @throws JsonProcessingException json缓存异常
     */
    void update(ArticleDO articleDO) throws JsonProcessingException;

    /**
     * 新增
     *
     * @param articleDO record
     * @param tagNameS 标签名数组
     * @throws JsonProcessingException json缓存异常
     */
    void insert(String[] tagNameS,ArticleDO articleDO) throws JsonProcessingException;

    /**
     * 删除
     *
     * @param ids ids
     * @throws JsonProcessingException json缓存异常
     */
    void delete(Long[] ids) throws JsonProcessingException;

    /**
     * 根据Id查询文章
     *
     * @param id id
     * @return ArticleBO
     */
    ArticleBO queryById(Long id);
}
