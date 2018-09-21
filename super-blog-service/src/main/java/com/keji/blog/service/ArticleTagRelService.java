package com.keji.blog.service;

import java.util.Map;

/**
 * @author wb-ny291824
 * @version $Id: ArticleTagRelService.java, v 0.1 2018-03-26 14:27 wb-ny291824 Exp $$
 */
public interface ArticleTagRelService {
    /**
     * 查询热门标签,以及关联的文章个数
     *
     * @return Map<String, Integer> string : 标签名称 integer: 关联的文章个数
     */
    Map<String, Integer> queryHotTag();

}
