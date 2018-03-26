package com.keji.blog.dataobject;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: CommentsDO.java, v 0.1 2018/3/26 11:23 wb-ny291824 Exp $
 */
@Data
public class CommentsDO {
    private Long id;

    private Long articleId;

    private Long userId;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer status;

    private String content;
}