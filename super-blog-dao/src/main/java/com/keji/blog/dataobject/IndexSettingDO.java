package com.keji.blog.dataobject;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * index_setting 表的实体类
 * 
 * @author : keji
 * @since : 2018-09-21
 */
public class IndexSettingDO {
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
     * 首页title
     */
    private String title;

    /**
     * logo路径
     */
    private String logoUrl;

    /**
     * favicon地址
     */
    private String faviconUrl;

    /**
     * 是否开启全文搜索(0：不开启 1:开启)
     */
    private Integer isSearch;

    /**
     * 搜索input框提示语
     */
    private String searchTip;

    /**
     * 搜索图标
     */
    private String searchIcon;

    /**
     * 背景图片地址
     */
    private String backgroundImageUrl;

    /**
     * 底部展示文字
     */
    private String bottomText;

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
     * 首页title
     * @return title 首页title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 首页title
     * @param title 首页title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * logo路径
     * @return logo_url logo路径
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * logo路径
     * @param logoUrl logo路径
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * favicon地址
     * @return favicon_url favicon地址
     */
    public String getFaviconUrl() {
        return faviconUrl;
    }

    /**
     * favicon地址
     * @param faviconUrl favicon地址
     */
    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl == null ? null : faviconUrl.trim();
    }

    /**
     * 是否开启全文搜索(0：不开启 1:开启)
     * @return is_search 是否开启全文搜索(0：不开启 1:开启)
     */
    public Integer getIsSearch() {
        return isSearch;
    }

    /**
     * 是否开启全文搜索(0：不开启 1:开启)
     * @param isSearch 是否开启全文搜索(0：不开启 1:开启)
     */
    public void setIsSearch(Integer isSearch) {
        this.isSearch = isSearch;
    }

    /**
     * 搜索input框提示语
     * @return search_tip 搜索input框提示语
     */
    public String getSearchTip() {
        return searchTip;
    }

    /**
     * 搜索input框提示语
     * @param searchTip 搜索input框提示语
     */
    public void setSearchTip(String searchTip) {
        this.searchTip = searchTip == null ? null : searchTip.trim();
    }

    public String getSearchIcon() {
        return searchIcon;
    }

    public void setSearchIcon(String searchIcon) {
        this.searchIcon = searchIcon;
    }

    /**
     * 背景图片地址
     * @return backgound_image_url 背景图片地址
     */
    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    /**
     * 背景图片地址
     * @param backgroundImageUrl 背景图片地址
     */
    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl == null ? null : backgroundImageUrl.trim();
    }

    /**
     * 底部展示文字
     * @return bottom_text 底部展示文字
     */
    public String getBottomText() {
        return bottomText;
    }

    /**
     * 底部展示文字
     * @param bottomText 底部展示文字
     */
    public void setBottomText(String bottomText) {
        this.bottomText = bottomText == null ? null : bottomText.trim();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}