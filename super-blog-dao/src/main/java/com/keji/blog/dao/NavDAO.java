package com.keji.blog.dao;

import com.keji.blog.dataobject.NavDO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wb-ny291824
 * @version $Id: NavDAO.java, v 0.1 2018/3/22 16:50 wb-ny291824 Exp $
 */
@Repository("navDAO")
public interface NavDAO extends BaseDAO<NavDO,NavDO>{

    void deleteBatch(Long[] ids);
}