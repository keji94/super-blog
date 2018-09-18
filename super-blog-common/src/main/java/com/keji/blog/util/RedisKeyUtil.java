package com.keji.blog.util;

/**
 * @author keji
 * @version $Id: RedisKeyUtil.java, v 0.1 2018-09-18 13:25 keji Exp $$
 */
public class RedisKeyUtil {

    public static final String SEPERATOR = "_";

    public static final String ARTICLE_PAGEREVIEWS_KEY_PREFIX = "article_pagereviews_key";

    public static String getArticlePageReviewsKey(Long id) {
        return ARTICLE_PAGEREVIEWS_KEY_PREFIX + SEPERATOR + id.toString();
    }
}
