package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsDO.java, v 0.1 2018-03-20 10:10 wb-ny291824 Exp $$
 */
@Data
public class TextSettingsDO implements Serializable {

    private static final long serialVersionUID = -2154140646863526401L;

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
     * logo文案
     */
    private String logo;

    /**
     * 标题文案
     */
    private String title;

    /**
     * 页眉文案
     */
    private String pageHeader;

    /**
     * 页尾文案
     */
    private String pageRooting;

    /**
     * 搜索文案
     */
    private String search;
    /**
     * 搜索 icon
     */
    private String searchIcon;

    /**
     * 创建时间icon
     */
    private String createTimeIcon;

    /**
     * 文章热度icon
     */
    private String hotIcon;

    /**
     * 评论功能开启
     */
    private Integer commentOpen;

    /**
     * 留言功能开启
     */
    private Integer leaveWordOpen;

    /**
     * 公告板信息
     */
    private String announcement;

    /**
     * 留言公告板信息
     */
    private String leaveWordAnnouncement;

    /**
     * icon 最新地址
     */
    private String iconUrl;

}
