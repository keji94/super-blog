package com.keji.blog.dataobject;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * link 表的实体类
 * 
 * @author : keji
 * @since : 2018-09-16
 */
public class LinkDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 链接名称
     */
    private String name;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 0：未删除 1:已删除
     */
    private Integer status;

    /**
     * icon图标
     */
    private String icon;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 修改时间
     * @return gmt_modified 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 修改时间
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 链接名称
     * @return name 链接名称
     */
    public String getName() {
        return name;
    }

    /**
     * 链接名称
     * @param name 链接名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 链接地址
     * @return url 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 链接地址
     * @param url 链接地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 0：未删除 1:已删除
     * @return status 0：未删除 1:已删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0：未删除 1:已删除
     * @param status 0：未删除 1:已删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * icon图标
     * @return icon icon图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * icon图标
     * @param icon icon图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}