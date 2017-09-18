package com.keji.blog.dataobject;

import java.util.Date;

public class BlogCategory {
    private Long categoryId;

    private String categoryName;

    private Boolean categoryStatus;

    private String categoryUrl;

    private Integer categoryOrdernum;

    private Boolean categoryIsparent;

    private Long categpryParentid;

    private Date categoryCreated;

    private Date categoryUpdated;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Boolean getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
    }

    public Integer getCategoryOrdernum() {
        return categoryOrdernum;
    }

    public void setCategoryOrdernum(Integer categoryOrdernum) {
        this.categoryOrdernum = categoryOrdernum;
    }

    public Boolean getCategoryIsparent() {
        return categoryIsparent;
    }

    public void setCategoryIsparent(Boolean categoryIsparent) {
        this.categoryIsparent = categoryIsparent;
    }

    public Long getCategpryParentid() {
        return categpryParentid;
    }

    public void setCategpryParentid(Long categpryParentid) {
        this.categpryParentid = categpryParentid;
    }

    public Date getCategoryCreated() {
        return categoryCreated;
    }

    public void setCategoryCreated(Date categoryCreated) {
        this.categoryCreated = categoryCreated;
    }

    public Date getCategoryUpdated() {
        return categoryUpdated;
    }

    public void setCategoryUpdated(Date categoryUpdated) {
        this.categoryUpdated = categoryUpdated;
    }
}