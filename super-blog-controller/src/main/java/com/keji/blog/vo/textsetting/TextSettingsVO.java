package com.keji.blog.vo.textsetting;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsDO.java, v 0.1 2018-03-20 10:10 wb-ny291824 Exp $$
 */
@Data
public class TextSettingsVO{

    /**
     * 主键
     */
    private Long id;

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
     * 主页文案
     */
    private String home;

    /**
     * 开发笔记文案
     */
    private String note;

    /**
     * 关于文案
     */
    private String about;

    /**
     * 信息板文案
     */
    private String informationBoard;

    /**
     * 搜索文案
     */
    private String search;

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
}
