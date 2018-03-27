package com.keji.blog.vo.article;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleDO.java, v 0.1 2018/3/27 11:55 wb-ny291824 Exp $
 */
public class ArticleVO implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getCommentable() {
        return commentable;
    }

    public void setCommentable(Integer commentable) {
        this.commentable = commentable;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", status=").append(status);
        sb.append(", top=").append(top);
        sb.append(", commentable=").append(commentable);
        sb.append(", userId=").append(userId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}