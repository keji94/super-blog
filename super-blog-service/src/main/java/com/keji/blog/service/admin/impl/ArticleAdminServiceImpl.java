package com.keji.blog.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.ArticleDAO;
import com.keji.blog.dataobject.ArticleDO;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.ArticleAdminService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.cache.ArticleCacheLoader;
import com.keji.blog.util.cache.CacheTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: NavServiceImpl.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
@Service
public class ArticleAdminServiceImpl implements ArticleAdminService {
    @Resource
    private ArticleDAO articleDAO;
    @Resource
    private CacheTemplate cacheTemplate;
    @Resource
    private ArticleCacheLoader articleCacheLoader;
    @Resource
    private RedisClient redisClient;

    @Override
    public PageInfo<ArticleDO> list(ArticleDO articleDO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ArticleDO> articleDOS = articleDAO.selectByCondition(articleDO);
        return new PageInfo<>(articleDOS);
    }

    @Override
    public List<ArticleDO> listAll(ArticleDO articleDO) {
        return cacheTemplate.findList(BlogConstants.ARTICLE_KEY, ArticleDO.class, articleCacheLoader, articleDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ArticleDO articleDO) throws JsonProcessingException {
        articleDAO.updateByPrimaryKeySelective(articleDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ArticleDO articleDO) throws JsonProcessingException {
        articleDAO.insert(articleDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long[] ids) throws JsonProcessingException {
        articleDAO.deleteBatch(ids);
        updateCache();
    }

    /**
     * 更新缓存
     * @throws JsonProcessingException json转换异常
     */
    private void updateCache() throws JsonProcessingException {
        //更新缓存
        List<ArticleDO> value = articleDAO.selectByCondition(new ArticleDO());
        redisClient.set(BlogConstants.ARTICLE_KEY, JsonUtil.object2Json(value));
    }
}
