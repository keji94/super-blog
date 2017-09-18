package com.keji.blog.dataobject;

import java.util.Date;

public class BlogComments {
    private Long commentId;

    private Long articleId;

    private Long userId;

    private Date commentCreated;

    private Date commentUpdated;

    private Boolean commentStatus;

    private String commentContent;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCommentCreated() {
        return commentCreated;
    }

    public void setCommentCreated(Date commentCreated) {
        this.commentCreated = commentCreated;
    }

    public Date getCommentUpdated() {
        return commentUpdated;
    }

    public void setCommentUpdated(Date commentUpdated) {
        this.commentUpdated = commentUpdated;
    }

    public Boolean getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}