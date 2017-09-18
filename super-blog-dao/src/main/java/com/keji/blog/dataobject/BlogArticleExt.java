package com.keji.blog.dataobject;

import java.util.Date;

public class BlogArticleExt {
    private Long extId;

    private Integer extGood;

    private Integer extBad;

    private Long articleId;

    private Date extCreate;

    private Date extUpdated;

    public Long getExtId() {
        return extId;
    }

    public void setExtId(Long extId) {
        this.extId = extId;
    }

    public Integer getExtGood() {
        return extGood;
    }

    public void setExtGood(Integer extGood) {
        this.extGood = extGood;
    }

    public Integer getExtBad() {
        return extBad;
    }

    public void setExtBad(Integer extBad) {
        this.extBad = extBad;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getExtCreate() {
        return extCreate;
    }

    public void setExtCreate(Date extCreate) {
        this.extCreate = extCreate;
    }

    public Date getExtUpdated() {
        return extUpdated;
    }

    public void setExtUpdated(Date extUpdated) {
        this.extUpdated = extUpdated;
    }
}