package com.keji.blog.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.keji.blog.dataobject.TagDO;
import lombok.Data;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleDO.java, v 0.1 2018/3/27 11:55 wb-ny291824 Exp $
 */
@Data
public class ArticleBO implements Serializable {
    private static final long serialVersionUID = 1936411868879163818L;
    /**
    * 文章id
    **/
    private Long id;

    /**
    * 文章标题
    **/
    private String title;

    /**
    * 文章状态，0：正常；1：删除
    **/
    private Integer status;

    /**
    * 是否置顶，1：置顶；0：不置顶
    **/
    private Integer top;

    /**
    * 是否可以评论 1：可以；0：不可以
    **/
    private Integer commentable;

    /**
    * 发表用户
    **/
    private Long userId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
    * 创建时间
    **/
    private Date gmtCreated;

    /**
    * 修改时间
    **/
    private Date gmtModified;

    /**
    * 文章内容
    **/
    private String content;

    /**
     * 点赞数
     */
    private Integer good;

    /**
     * 踩数
     */
    private Integer bad;

    /**
     * 浏览数
     */
    private Integer pageviews;

    /**
     * 文章标签数
     */
    private List<TagDO> tagDOS;
}