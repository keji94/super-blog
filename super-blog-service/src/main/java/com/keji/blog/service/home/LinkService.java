package com.keji.blog.service.home;

import java.util.List;

import com.keji.blog.bo.LinkBO;

/**
 * @author keji
 * @version $Id: LinkService.java, v 0.1 2018-09-16 11:31 keji Exp $$
 */
public interface LinkService {

    /**
     * 链接查询
     *
     * @param linkBO linkBO
     * @return  List<LinkBO>
     */
    List<LinkBO> listAll(LinkBO linkBO);
}
