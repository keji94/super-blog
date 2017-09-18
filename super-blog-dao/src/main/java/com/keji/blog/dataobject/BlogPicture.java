package com.keji.blog.dataobject;

import java.util.Date;

public class BlogPicture {
    private Long pictureId;

    private String pictureName;

    private String pictureResource;

    private Boolean pictureStatus;

    private Integer pictureOrdernum;

    private Long articleId;

    private Date pictureCreated;

    private Date pictureUpdated;

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPictureResource() {
        return pictureResource;
    }

    public void setPictureResource(String pictureResource) {
        this.pictureResource = pictureResource == null ? null : pictureResource.trim();
    }

    public Boolean getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(Boolean pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Integer getPictureOrdernum() {
        return pictureOrdernum;
    }

    public void setPictureOrdernum(Integer pictureOrdernum) {
        this.pictureOrdernum = pictureOrdernum;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getPictureCreated() {
        return pictureCreated;
    }

    public void setPictureCreated(Date pictureCreated) {
        this.pictureCreated = pictureCreated;
    }

    public Date getPictureUpdated() {
        return pictureUpdated;
    }

    public void setPictureUpdated(Date pictureUpdated) {
        this.pictureUpdated = pictureUpdated;
    }
}