package com.keji.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.keji.blog.bo.ArticleBO;
import com.keji.blog.dataobject.ArticleDO;
import com.keji.blog.vo.article.ArticleInsertVO;
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
        articleBO.setContent(articleVO.getContent());
        articleBO.setStatus(articleVO.getStatus());
        return articleBO;
    }

    public static ArticleDO convertVO2DO(ArticleVO articleVO) {
        ArticleDO articleDO = new ArticleDO();
        articleDO.setTitle(articleVO.getTitle());
        articleDO.setId(articleVO.getId());
        articleDO.setStatus(articleVO.getStatus());
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
        articleVO.setContent(articleBO.getContent());
        articleVO.setStatus(articleBO.getStatus());
        articleVO.setPageViews(articleBO.getPageviews());
        articleVO.setTagDOS(articleBO.getTagDOS());
        articleVO.setPreviewStyle(articleBO.getPreviewStyle());
        articleVO.setArticleImageDOS(articleBO.getArticleImageDOS());
        articleVO.setGmtCreated(articleBO.getGmtCreate());
        return articleVO;
    }
}
