package com.keji.blog.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.keji.blog.dataobject.ArticleImageDO;
import com.keji.blog.dataobject.TagDO;
import lombok.Data;

/**
 * @author wb-ny291824
 * @version $Id: ArticleDO.java, v 0.1 2018/3/27 11:55 wb-ny291824 Exp $
 */
@Data
public class ArticleBO implements Serializable {
    private static final long serialVersionUID = 1936411868879163818L;
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
     * 内容
     */
    private String content;

    /**
     * 浏览数
     */
    private Integer pageviews;

    /**
     * 文章标签
     */
    private List<TagDO> tagDOS;

    /**
     * 文章图片
     */
    private List<ArticleImageDO> articleImageDOS;
}