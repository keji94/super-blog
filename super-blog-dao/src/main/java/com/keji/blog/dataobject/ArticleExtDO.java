package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleExtDO.java, v 0.1 2018/3/27 11:55 wb-ny291824 Exp $
 */
public class ArticleExtDO implements Serializable {
    /**
    * 主键
    **/
    private Long id;

    /**
    * 文章顶数量
    **/
    private Integer good;

    /**
    * 文章踩数量
    **/
    private Integer bad;

    /**
    * 浏览数
    **/
    private Integer pageviews;

    private Long articleId;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getBad() {
        return bad;
    }

    public void setBad(Integer bad) {
        this.bad = bad;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", good=").append(good);
        sb.append(", bad=").append(bad);
        sb.append(", pageViews=").append(pageviews);
        sb.append(", articleId=").append(articleId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }
}