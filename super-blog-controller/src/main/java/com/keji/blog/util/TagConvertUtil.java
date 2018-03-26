package com.keji.blog.util;

import com.keji.blog.dataobject.TagDO;
import com.keji.blog.vo.tag.TagQueryVO;
import com.keji.blog.vo.tag.TagVO;

/**
 * @author wb-ny291824
 * @version $Id: TagConvertUtil.java, v 0.1 2018-03-22 17:43 wb-ny291824 Exp $$
 */
public class TagConvertUtil {

    public static TagDO convertQueryVO2DO(TagQueryVO queryVO) {
        TagDO tagDO = new TagDO();
        tagDO.setName(queryVO.getName());
        return tagDO;
    }

    public static TagDO convertVO2DO(TagVO tagVO) {
        TagDO navDO = new TagDO();
        navDO.setName(tagVO.getName());
        navDO.setId(tagVO.getId());
        navDO.setGmtCreate(tagVO.getGmtCreate());
        navDO.setGmtModified(tagVO.getGmtModified());
        return navDO;
    }
}
