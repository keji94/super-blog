package com.keji.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.bo.ArticleBO;
import com.keji.blog.dataobject.ArticleDO;
import com.keji.blog.vo.article.ArticleQueryVO;
import com.keji.blog.vo.article.ArticleVO;

/**
 * @author wb-ny291824
 * @version $Id: TagConvertUtil.java, v 0.1 2018-03-22 17:43 wb-ny291824 Exp $$
 */
public class ArticleConvertUtil {

    public static ArticleBO convertQueryVO2BO(ArticleQueryVO queryVO) {
        ArticleBO articleBO = new ArticleBO();
        articleBO.setTitle(queryVO.getTitle());
        return articleBO;
    }

    public static ArticleBO convertVO2BO(ArticleVO articleVO) {
        ArticleBO articleBO = new ArticleBO();
        articleBO.setTitle(articleVO.getTitle());
        articleBO.setId(articleVO.getId());
        articleBO.setCategoryId(articleVO.getCategoryId());
        articleBO.setCommentable(articleVO.getCommentable());
        articleBO.setContent(articleVO.getContent());
        articleBO.setStatus(articleVO.getStatus());
        articleBO.setTop(articleVO.getTop());
        articleBO.setUserId(articleVO.getUserId());
        articleBO.setGmtModified(articleVO.getGmtModified());
        return articleBO;
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

    public static List<ArticleVO> convertBOS2VOS(List<ArticleBO> articleBOS) {
        ArrayList<ArticleVO> list = Lists.newArrayList();
        articleBOS.forEach(e->list.add(convertBO2VO(e)));
        return list;
    }

    public static ArticleVO convertBO2VO(ArticleBO articleBO) {
        if (null == articleBO) {
            return null;
        }
        ArticleVO articleVO = new ArticleVO();
        articleVO.setTitle(articleBO.getTitle());
        articleVO.setId(articleBO.getId());
        articleVO.setCategoryId(articleBO.getCategoryId());
        articleVO.setCategoryName(articleBO.getCategoryName());
        articleVO.setCommentable(articleBO.getCommentable());
        articleVO.setContent(articleBO.getContent());
        articleVO.setStatus(articleBO.getStatus());
        articleVO.setTop(articleBO.getTop());
        articleVO.setUserId(articleBO.getUserId());
        articleVO.setGmtModified(articleBO.getGmtModified());
        articleVO.setGmtCreated(articleBO.getGmtCreated());
        articleVO.setPageviews(articleBO.getPageviews());
        articleVO.setGood(articleBO.getGood());
        articleVO.setBad(articleBO.getBad());
        articleVO.setTagDOS(articleBO.getTagDOS());
        return articleVO;
    }
}
