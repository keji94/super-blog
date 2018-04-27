package com.keji.blog.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.blog.bo.ArticleBO;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.ArticleDAO;
import com.keji.blog.dataobject.ArticleDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.service.admin.ArticleAdminService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.redis.loader.ArticleCacheLoader;
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
    private CacheService cacheService;
    @Resource
    private ArticleCacheLoader articleCacheLoader;
    @Resource
    private RedisClient redisClient;

    @Override
    public PageInfo<ArticleBO> list(ArticleBO articleBO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ArticleBO> articleBOS = articleDAO.selectByCondition(articleBO);
        return new PageInfo<>(articleBOS);
    }

    @Override
    public List<ArticleBO> listAll(ArticleBO articleBO) {
        return cacheService.findListSafety(BlogConstants.ARTICLE_KEY, ArticleBO.class, articleCacheLoader, articleBO);
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
        List<ArticleBO> value = articleDAO.selectByCondition(new ArticleBO());
        redisClient.set(BlogConstants.ARTICLE_KEY, JsonUtil.object2Json(value));
    }
}
