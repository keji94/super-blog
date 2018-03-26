package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleTagRelDO.java, v 0.1 2018/3/26 14:34 wb-ny291824 Exp $
 */
public class ArticleTagRelDO implements Serializable {
    /**
    * 主键
    **/
    private Long id;

    /**
    * 创建时间
    **/
    private Date gmtCreate;

    /**
    * 修改时间
    **/
    private Date gmtModified;

    private Long articleId;

    private Long tagId;

    /**
    * 标签名称
    **/
    private String tagName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", articleId=").append(articleId);
        sb.append(", tagId=").append(tagId);
        sb.append(", tagName=").append(tagName);
        sb.append("]");
        return sb.toString();
    }
}