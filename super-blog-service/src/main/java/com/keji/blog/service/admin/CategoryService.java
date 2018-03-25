package com.keji.blog.service.admin;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keji.blog.dataobject.CategoryDO;

/**
 * @author keji
 * @version $Id: CategoryService.java, v 0.1 2018-03-25 下午3:43 keji Exp $$
 */
public interface CategoryService {

    /**
     * 查询所有
     *
     * @param record record
     * @return List<InfoBoardDO>
     */
    List<CategoryDO> listAll(CategoryDO record);

    /**
     * 修改
     * @param record record
     */
    void update(CategoryDO record) throws JsonProcessingException;

    /**
     * 新增
     * @param record record
     */
    void insert(CategoryDO record) throws JsonProcessingException;

    /**
     * 删除
     * @param id id
     */
    void delete(Long id) throws JsonProcessingException;

    /**
     * 根据id查询
     * @param id id
     * @return CategoryDO
     */
    CategoryDO queryById(Long id);
}
