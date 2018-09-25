package com.keji.blog.dataobject;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * update_time_line 表的实体类
 * 
 * @author : keji
 * @since : 2018-09-16
 */
public class UpdateTimeLineDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 状态(0:normal（计划执行），1:warning(警告),2：success（成功更新))
     */
    private Integer status;

    /**
     * 0：未删除 1：已删除
     */
    private Integer isDel;

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

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 创建时间
     * @return gmt_create 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 创建时间
     * @param gmtCreate 创建时间
     */
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
     * 状态(0:normal（计划执行），1:warning(警告),2：success（成功更新))
     * @return status 状态(0:normal（计划执行），1:warning(警告),2：success（成功更新))
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(0:normal（计划执行），1:warning(警告),2：success（成功更新))
     * @param status 状态(0:normal（计划执行），1:warning(警告),2：success（成功更新))
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 0：未删除 1：已删除
     * @return is_del 0：未删除 1：已删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 0：未删除 1：已删除
     * @param isDel 0：未删除 1：已删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}