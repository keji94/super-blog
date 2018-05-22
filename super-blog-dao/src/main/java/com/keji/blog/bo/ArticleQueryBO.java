package com.keji.blog.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.keji.blog.dataobject.TagDO;
import lombok.Data;

/**
 *
 * @author wb-ny291824
 * @version $Id: ArticleDO.java, v 0.1 2018/3/27 11:55 wb-ny291824 Exp $
 */
@Data
public class ArticleQueryBO extends PageQueryBO implements Serializable{
    private static final long serialVersionUID = 1936411868879163818L;
    /**
    * 文章id
    **/
    private Long id;

    /**
    * 文章标题
    **/
    private String title;

}