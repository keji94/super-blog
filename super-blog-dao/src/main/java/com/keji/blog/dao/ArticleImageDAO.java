package com.keji.blog.dao;

import java.util.List;

import com.keji.blog.dataobject.ArticleImageDO;
import org.springframework.stereotype.Repository;

/**
 * @author keji
 * @version $Id: ArticleImageDAO.java, v 0.1 2018-09-14 14:01 keji Exp $$
 */
@Repository
public interface ArticleImageDAO {

    /**
     * 根据文章id查询
     *
     * @param articleId 文章id
     * @return List<ArticleImageDO>
     */
    List<ArticleImageDO> selectByArticleId(Long articleId);
}
