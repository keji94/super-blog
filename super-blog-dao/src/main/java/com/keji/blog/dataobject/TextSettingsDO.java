package com.keji.blog.dataobject;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author wb-ny291824
 * @version $Id: TextSettingsDO.java, v 0.1 2018-03-20 10:10 wb-ny291824 Exp $$
 */
public class TextSettingsDO  implements Serializable {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader == null ? null : pageHeader.trim();
    }

    public String getPageRooting() {
        return pageRooting;
    }

    public void setPageRooting(String pageRooting) {
        this.pageRooting = pageRooting == null ? null : pageRooting.trim();
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home == null ? null : home.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }

    public String getInformationBoard() {
        return informationBoard;
    }

    public void setInformationBoard(String informationBoard) {
        this.informationBoard = informationBoard == null ? null : informationBoard.trim();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
