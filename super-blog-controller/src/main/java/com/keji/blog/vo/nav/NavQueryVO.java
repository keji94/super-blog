package com.keji.blog.vo.nav;

import com.keji.blog.vo.BaseQueryVO;
import lombok.Data;

/**
 *
 * @author wb-ny291824
 * @version $Id: NavDO.java, v 0.1 2018/3/22 17:28 wb-ny291824 Exp $
 */
@Data
public class NavQueryVO extends BaseQueryVO{
    private String name;

    private String icon;

    private String url;
}