package com.keji.blog.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.BindingResult;

/**
 * 
 * @author keji
 * @version $Id: PageResult.java, v 0.1 2018/5/20 下午12:41 keji Exp $
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResult<T> extends BaseResult<T> {

    private static final long serialVersionUID = -6894417970085071327L;
    /**
     * 总个数
     */
    protected Long totalCount;

    /**
     * 总页数
     */
    protected int totalPage;

    public PageResult(){
        super();
    }

    public PageResult(T data, Long totalCount) {
        this.setData(data);
        this.totalCount = totalCount;
    }

    public static <T> PageResult<T> makeSuccess(T data) {
        PageResult<T> result = new PageResult<>();
        result.success(data);
        return result;
    }

    public static<T> PageResult<T> makeSuccess(T data, Long totalCount) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setSuccess(true);
        pageResult.setTotalCount(totalCount);
        pageResult.setData(data);
        return pageResult;
    }

    public static<T> PageResult<T> makeSuccess(T data, Long totalCount,int totalPage) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setSuccess(true);
        pageResult.setTotalCount(totalCount);
        pageResult.setData(data);
        pageResult.setTotalPage(totalPage);
        return pageResult;
    }

    public static<T> PageResult<T> makeFail(BaseErrorEnum errorEnum) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setSuccess(false);
        pageResult.setErrorCode(errorEnum.getErrorCode());
        pageResult.setErrorMsg(errorEnum.getErrorMsg());
        return pageResult;
    }

    public static<T> PageResult<T> makeFail(String errorMsg) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setSuccess(false);
        pageResult.setErrorCode("");
        pageResult.setErrorMsg(errorMsg);
        return pageResult;
    }

    public static <T> PageResult<T> makeFail(BindingResult bindingResult) {
        PageResult<T> result = new PageResult<T>();
        String message = null;
        if (bindingResult.hasErrors()) {
            //如果有多个错误信息,返回第一个
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        result.fail("", message);
        return result;
    }

}
