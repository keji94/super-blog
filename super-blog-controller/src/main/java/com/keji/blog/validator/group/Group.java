package com.keji.blog.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @author keji
 * @version $Id: Group.java, v 0.1 2018/3/18 下午2:45 keji Exp $
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
