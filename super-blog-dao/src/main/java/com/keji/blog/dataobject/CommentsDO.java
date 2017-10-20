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
public class CommentsDO {
    private Long id;

    private Long articleId;

    private Long userId;

    private Date gmtCreated;

    private Date gmtModified;

    private Integer status;

    private String content;
}