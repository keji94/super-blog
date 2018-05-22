package com.keji.blog.bo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author keji
 * @version $Id: PageQueryBO.java, v 0.1 2018/5/22 下午7:07 keji Exp $
 */
public class PageQueryBO {

    /**
     * 分页开始索引
     */
    private Integer startIndex;

    /**
     * 每页显示个数
     */
    private Integer pageSize;

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
