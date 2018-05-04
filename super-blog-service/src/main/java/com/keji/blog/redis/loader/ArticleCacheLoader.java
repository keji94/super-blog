package com.keji.blog.redis.loader;

import java.util.List;

import javax.annotation.Resource;

import com.keji.blog.bo.ArticleBO;
import com.keji.blog.dao.ArticleDAO;
import com.keji.blog.redis.CacheLoader;
import org.springframework.stereotype.Component;

/**
 * @author wb-ny291824
 * @version $Id: ArticleCacheLoader.java, v 0.1 2018-03-22 17:06 wb-ny291824 Exp $$
 */
@Component
public class ArticleCacheLoader implements CacheLoader<ArticleBO> {

    @Resource
    private ArticleDAO articleDAO;

    @Override
    public List<ArticleBO> load(ArticleBO articleBO) {
        return articleDAO.selectByCondition(articleBO);
    }
}