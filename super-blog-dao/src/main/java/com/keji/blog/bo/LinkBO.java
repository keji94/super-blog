package com.keji.blog.bo;

import java.util.Date;
import java.util.List;

import com.keji.blog.dataobject.LinkDO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 * 
 * link 表的DO
 * 
 * @author : Administrator
 * @since : 2018-09-16
 */
public class LinkBO {

    /**
     * 该分类下的链接
     */
    private List<LinkDO> linkDOS;
    /**
     * 分类名称
     */
    private String categoryName;

    public List<LinkDO> getLinkDOS() {
        return linkDOS;
    }

    public void setLinkDOS(List<LinkDO> linkDOS) {
        this.linkDOS = linkDOS;
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