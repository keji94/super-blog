package com.keji.blog.util;

import com.keji.blog.dataobject.ArticleDO;
import com.keji.blog.dataobject.TagDO;
import com.keji.blog.vo.article.ArticleQueryVO;
import com.keji.blog.vo.article.ArticleVO;
import com.keji.blog.vo.tag.TagQueryVO;
import com.keji.blog.vo.tag.TagVO;

/**
 * @author wb-ny291824
 * @version $Id: TagConvertUtil.java, v 0.1 2018-03-22 17:43 wb-ny291824 Exp $$
 */
public class ArticleConvertUtil {

    public static ArticleDO convertQueryVO2DO(ArticleQueryVO queryVO) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setTitle(queryVO.getTitle());
        return articleDO;
    }

    public static ArticleDO convertVO2DO(ArticleVO articleVO) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setTitle(articleVO.getTitle());
        articleDO.setId(articleVO.getId());
        articleDO.setCategoryId(articleVO.getCategoryId());
        articleDO.setCommentable(articleVO.getCommentable());
        articleDO.setContent(articleVO.getContent());
        articleDO.setStatus(articleVO.getStatus());
        articleDO.setTop(articleVO.getTop());
        articleDO.setUserId(articleVO.getUserId());
        articleDO.setGmtModified(articleVO.getGmtModified());
        return articleDO;
    }

    public static ArticleVO convertDO2VO(ArticleDO articleDO) {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setTitle(articleDO.getTitle());
        articleVO.setId(articleDO.getId());
        articleVO.setCategoryId(articleDO.getCategoryId());
        articleVO.setCommentable(articleDO.getCommentable());
        articleVO.setContent(articleDO.getContent());
        articleVO.setStatus(articleDO.getStatus());
        articleVO.setTop(articleDO.getTop());
        articleVO.setUserId(articleDO.getUserId());
        articleVO.setGmtModified(articleDO.getGmtModified());
        return articleVO;
    }
}
