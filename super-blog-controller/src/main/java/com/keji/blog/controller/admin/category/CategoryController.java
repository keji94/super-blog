package com.keji.blog.controller.admin.category;

import java.util.List;

import com.keji.blog.dataobject.CategoryDO;
import com.keji.blog.dataobject.ResourceDO;
import com.keji.blog.exception.BlogException;
import com.keji.blog.result.BaseErrorEnum;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.admin.CategoryService;
import com.keji.blog.service.admin.ResourceService;
import com.keji.blog.util.ResourceConvertUtil;
import com.keji.blog.util.ValidatorUtils;
import com.keji.blog.validator.group.AddGroup;
import com.keji.blog.validator.group.UpdateGroup;
import com.keji.blog.vo.category.CategoryVO;
import com.keji.blog.vo.resource.ResourceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wb-ny291824
 * @version $Id: CategoryController.java, v 0.1 2017-10-26 19:21 wb-ny291824 Exp $$
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/categoryTree")
    public List<CategoryDO> categoryTree() {

        List<CategoryDO> categoryDOS;
        try {
            categoryDOS = categoryService.listAll(new CategoryDO());
            //添加顶级菜单
            CategoryDO root = new CategoryDO();
            root.setId(0L);
            root.setName("一级菜单");
            root.setParentId(-1L);
            categoryDOS.add(root);
        } catch (Exception e) {
            logger.error("查询资源失败", e);
            return null;
        }

        return categoryDOS;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<CategoryDO> query() {

        List<CategoryDO> categoryDOS;
        try {
            categoryDOS = categoryService.listAll(new CategoryDO());
        } catch (Exception e) {
            logger.error("查询资源失败", e);
            return null;
        }

        return categoryDOS;
    }



    @ResponseBody
    @RequestMapping("/queryById")
    public BaseResult<CategoryDO> queryById(Long id) {

        CategoryDO categoryDO;
        try {
            categoryDO = categoryService.queryById(id);
        } catch (Exception e) {
            logger.error("CategoryController#queryById,根据id查询资源失败,id:" + id, e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess(categoryDO);
    }

    @ResponseBody
    @RequestMapping("/save")
    public BaseResult save(@RequestBody CategoryVO categoryVO) {

        try {
            ValidatorUtils.validateEntity(categoryVO, AddGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        }

        try {
            categoryService.insert(convertVO2DO(categoryVO));
        } catch (Exception e) {
            logger.error("CategoryController#save,新增接口失败...", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    @ResponseBody
    @RequestMapping("/update")
    public BaseResult update(@RequestBody CategoryVO categoryVO) {

        try {
            ValidatorUtils.validateEntity(categoryVO, UpdateGroup.class);
        } catch (BlogException e) {
            return BaseResult.makeFail(e.getMsg());
        }

        try {
            categoryService.update(convertVO2DO(categoryVO));
        } catch (Exception e) {
            logger.error("CategoryController#update,更新接口失败...", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResult delete(Long id) {

        if (id == null) {
            return BaseResult.makeFail(BaseErrorEnum.PARAM_ERROR);
        }

        try {
            categoryService.delete(id);
        } catch (Exception e) {
            logger.error("CategoryController#delete,删除接口失败...", e);
            return BaseResult.makeFail(BaseErrorEnum.SYSTEM_ERROR);
        }

        return BaseResult.makeSuccess();
    }

    private CategoryDO convertVO2DO(CategoryVO categoryVO) {
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setGmtCreated(categoryVO.getGmtCreated());
        categoryDO.setGmtModified(categoryVO.getGmtModified());
        categoryDO.setId(categoryVO.getId());
        categoryDO.setName(categoryVO.getName());
        categoryDO.setParentId(categoryVO.getParentId());
        categoryDO.setParentName(categoryVO.getParentName());
        categoryDO.setType(categoryVO.getType());
        return categoryDO;
    }
}
