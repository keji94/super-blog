package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleExtDO.java, v 0.1 2018/3/26 11:22 wb-ny291824 Exp $
 */
@Data
public class ArticleExtDO {
    private Long id;

    private Integer good;

    private Integer bad;

    private Long articleId;

    private Date gmtCreated;

    private Date gmtModified;
}