package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleDO.java, v 0.1 2018/3/27 11:55 wb-ny291824 Exp $
 */
public class ArticleDO implements Serializable {

    private static final long serialVersionUID = -4641730174827633704L;
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
    private Date gmtUpdated;

    /**
     * 状态(0:已删除 1：正常 2：置顶)
     */
    private Integer status;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 是否允许评论(0:不允许 1:允许)
     */
    private Integer isComment;

    /**
     * 首页预览样式(0:normal 1:advanced 2:多图模式)
     */
    private Integer previewStyle;

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
     * @return gmt_updated 修改时间
     */
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    /**
     * 修改时间
     * @param gmtUpdated 修改时间
     */
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    /**
     * 状态(0:已删除 1：正常 2：置顶)
     * @return status 状态(0:已删除 1：正常 2：置顶)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(0:已删除 1：正常 2：置顶)
     * @param status 状态(0:已删除 1：正常 2：置顶)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 文章标题
     * @return title 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 文章标题
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 是否允许评论(0:不允许 1:允许)
     * @return is_comment 是否允许评论(0:不允许 1:允许)
     */
    public Integer getIsComment() {
        return isComment;
    }

    /**
     * 是否允许评论(0:不允许 1:允许)
     * @param isComment 是否允许评论(0:不允许 1:允许)
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * 首页预览样式(0:normal 1:advanced 2:多图模式)
     * @return preview_style 首页预览样式(0:normal 1:advanced 2:多图模式)
     */
    public Integer getPreviewStyle() {
        return previewStyle;
    }

    /**
     * 首页预览样式(0:normal 1:advanced 2:多图模式)
     * @param previewStyle 首页预览样式(0:normal 1:advanced 2:多图模式)
     */
    public void setPreviewStyle(Integer previewStyle) {
        this.previewStyle = previewStyle;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}