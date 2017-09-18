package com.keji.blog.dataobject;

import java.util.Date;

public class BlogArticle {
    private Long articleId;

    private String articleTitle;

    private Boolean articleStatus;

    private Boolean articleIstop;

    private Long userId;

    private Long categoryId;

    private Date articleCreated;

    private Date articleUpdated;

    private String articleContent;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Boolean getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Boolean articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Boolean getArticleIstop() {
        return articleIstop;
    }

    public void setArticleIstop(Boolean articleIstop) {
        this.articleIstop = articleIstop;
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

    public Date getArticleCreated() {
        return articleCreated;
    }

    public void setArticleCreated(Date articleCreated) {
        this.articleCreated = articleCreated;
    }

    public Date getArticleUpdated() {
        return articleUpdated;
    }

    public void setArticleUpdated(Date articleUpdated) {
        this.articleUpdated = articleUpdated;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}