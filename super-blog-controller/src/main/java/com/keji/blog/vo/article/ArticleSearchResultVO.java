package com.keji.blog.vo.article;

import java.util.List;

import com.keji.blog.bo.ArticleBO;
import lombok.Data;

/**
 * @author keji
 * @version $Id: ArticleSearchResultVO.java, v 0.1 2018-09-18 9:53 keji Exp $$
 */
@Data
public class ArticleSearchResultVO {

    /**
     * 关键字
     */
    private String key;

    /**
     * 重量
     */
    private Integer total;

    /**
     * 文章
     */
    private List<ArticleBO> articleBOS;
}
