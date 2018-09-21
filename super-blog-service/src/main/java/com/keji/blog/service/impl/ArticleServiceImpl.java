package com.keji.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.keji.blog.bo.ArticleBO;
import com.keji.blog.constants.BlogConstants;
import com.keji.blog.dao.ArticleDAO;
import com.keji.blog.dao.ArticleTagRelDAO;
import com.keji.blog.dao.TagDAO;
import com.keji.blog.dataobject.ArticleDO;
import com.keji.blog.dataobject.ArticleTagRelDO;
import com.keji.blog.dataobject.TagDO;
import com.keji.blog.redis.CacheService;
import com.keji.blog.redis.RedisClient;
import com.keji.blog.redis.loader.ArticleCacheLoader;
import com.keji.blog.service.ArticleService;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.RedisKeyUtil;
import com.keji.blog.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wb-ny291824
 * @version $Id: NavServiceImpl.java, v 0.1 2018-03-22 16:48 wb-ny291824 Exp $$
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDAO articleDAO;
    @Resource
    private CacheService cacheService;
    @Resource
    private ArticleCacheLoader articleCacheLoader;
    @Resource
    private RedisClient redisClient;
    @Resource
    private ArticleTagRelDAO articleTagRelDAO;
    @Resource
    private TagDAO tagDAO;

    @Override
    public PageInfo<ArticleBO> list(ArticleBO articleBO, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ArticleBO> articleBOS = articleDAO.selectWithBlobs(null,null);

        for (ArticleBO bo : articleBOS) {
            String delHtmlTag = StringUtil.delHtmlTag(bo.getContent());
            if (delHtmlTag.length() > 200) {
                delHtmlTag = delHtmlTag.substring(0, 200);
            }

            String pageReviews = redisClient.get(RedisKeyUtil.getArticlePageReviewsKey(bo.getId()));

            bo.setPageviews(StringUtils.isEmpty(pageReviews) ? 0 : Integer.parseInt(pageReviews));
            bo.setContent(delHtmlTag);
        }

        setArticleTag(articleBOS);
        return new PageInfo<>(articleBOS);
    }

    @Override
    public List<ArticleBO> listAll(ArticleBO articleBO) {
        return cacheService.findList(BlogConstants.ARTICLE_KEY, ArticleBO.class, articleCacheLoader, articleBO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ArticleDO articleDO) {
        articleDAO.updateByPrimaryKeySelective(articleDO);
        updateCache();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(String[] tagNameS, ArticleDO articleDO) {
        List<TagDO> tagDOS = assembleTagDOS(tagNameS);
        tagDAO.insertBatch(tagDOS);
        articleDAO.insert(articleDO);
        articleTagRelDAO.insertBatch(assembleArticleTagRelDOS(tagDOS, articleDO));
        updateCache();
    }

    @Override
    public ArticleBO queryById(Long id) {
        List<ArticleBO> list = articleDAO.selectWithBlobs(null,id);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ArticleBO> queryByTitle(String key) {
        return articleDAO.selectWithBlobs(key,null);
    }

    @Override
    public void delete(Long[] ids) {
        articleDAO.deleteBatch(ids);
    }

    private void setArticleTag(List<ArticleBO> articleBOS) {
        List<ArticleTagRelDO> articleTagRelDOS = articleTagRelDAO.selectByArticleIds(
                articleBOS.stream().map(ArticleBO::getId).collect(Collectors.toList()));
        articleBOS.forEach(articleBO -> {
            List<ArticleTagRelDO> collect = articleTagRelDOS.stream().filter(
                    e -> e.getArticleId().equals(articleBO.getId())).collect(Collectors.toList());
            List<TagDO> tagDOS = Lists.newArrayList();
            collect.forEach(e -> {
                TagDO tagDO = new TagDO();
                tagDO.setId(e.getId());
                tagDO.setName(e.getTagName());
                tagDOS.add(tagDO);
            });
            articleBO.setTagDOS(tagDOS);
        });
    }

    /**
     * 更新缓存
     */
    private void updateCache() {
        //更新缓存
        List<ArticleBO> value = articleDAO.selectWithBlobs(null,null);
        redisClient.set(BlogConstants.ARTICLE_KEY, JsonUtil.object2Json(value));
    }

    private List<TagDO> assembleTagDOS(String[] tagNameS) {
        List<TagDO> tagDOS = Lists.newArrayList();
        for (String tagName : tagNameS) {
            TagDO tagDO = new TagDO();
            tagDO.setName(tagName);
            tagDOS.add(tagDO);
        }
        return tagDOS;
    }

    private List<ArticleTagRelDO> assembleArticleTagRelDOS(List<TagDO> tagDOS, ArticleDO articleDO) {
        List<ArticleTagRelDO> result = Lists.newArrayList();
        tagDOS.forEach(e -> {
            ArticleTagRelDO articleTagRelDO = new ArticleTagRelDO();
            articleTagRelDO.setArticleId(articleDO.getId());
            articleTagRelDO.setTagId(e.getId());
            articleTagRelDO.setTagName(e.getName());
            result.add(articleTagRelDO);
        });
        return result;
    }
}
