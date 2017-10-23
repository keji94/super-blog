package com.keji.blog.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.BindingResult;

/**
 * @author: wb-ny291824
 * @description EqualsAndHashCode 这个注解不知道啥意思，但是ide报警告，加上为了不报警告
 * @date: Created in 2017/10/22
 * @modified: By:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResult<T> extends BaseResult<T> {

    /**
     * 总个数
     */
    protected Long totalCount;

    /**
     * 排序方式
     */
    protected String orderBy;

    public PageResult(){
        super();
    }

    public PageResult(T data, Long totalCount) {
        this.setData(data);
        this.totalCount = totalCount;
    }

    public static<T> PageResult<T> makeSuccess(T data, Long totalCount) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setSuccess(true);
        pageResult.setTotalCount(totalCount);
        pageResult.setData(data);
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
