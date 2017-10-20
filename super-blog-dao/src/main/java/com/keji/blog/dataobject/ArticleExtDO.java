package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/10/19
 * @modified: By:
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