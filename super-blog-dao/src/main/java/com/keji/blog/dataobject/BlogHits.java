package com.keji.blog.dataobject;

import java.util.Date;

public class BlogHits {
    private Long hitsId;

    private Long articleId;

    private Long hitCount;

    private Date hitsCreated;

    private Date hitsUpdated;

    public Long getHitsId() {
        return hitsId;
    }

    public void setHitsId(Long hitsId) {
        this.hitsId = hitsId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getHitCount() {
        return hitCount;
    }

    public void setHitCount(Long hitCount) {
        this.hitCount = hitCount;
    }

    public Date getHitsCreated() {
        return hitsCreated;
    }

    public void setHitsCreated(Date hitsCreated) {
        this.hitsCreated = hitsCreated;
    }

    public Date getHitsUpdated() {
        return hitsUpdated;
    }

    public void setHitsUpdated(Date hitsUpdated) {
        this.hitsUpdated = hitsUpdated;
    }
}