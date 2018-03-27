package com.keji.blog.util.cache;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.dao.ArticleDAO;
import com.keji.blog.dataobject.ArticleDO;
import org.springframework.stereotype.Component;

/**
 * @author wb-ny291824
 * @version $Id: NavCacheLoader.java, v 0.1 2018-03-22 17:06 wb-ny291824 Exp $$
 */
@Component
public class ArticleCacheLoader implements CacheLoader<ArticleDO>{

    @Resource
    private ArticleDAO articleDAO;

    @Override
    public List<ArticleDO> load(ArticleDO articleDO) {
        return articleDAO.selectByCondition(articleDO);
    }
}
