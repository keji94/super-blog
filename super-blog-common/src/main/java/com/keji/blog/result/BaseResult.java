package com.keji.blog.result;

import lombok.Data;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 7448055195717653190L;

    /**
     * 是否成功
     */
    protected boolean success = true;

    /**
     * 业务数据
     */
    protected T data;

    /**
     * 错误代码
     */
    protected String errorCode;

    /**
     * 错误信息
     */
    protected String errorMsg;

    /**
     * 冗余提示信息
     */
    private String message;

    /**
     * 默认返回成功
     */
    public BaseResult() {
        this.success = true;
    }

    public BaseResult(boolean success) {
        this.success = success;
    }

    public BaseResult(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    public BaseResult<T> success(T data) {
        this.data = data;
        this.success = true;
        return this;
    }

    public BaseResult<T> fail(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        return this;
    }

    public BaseResult<T> fail(BaseErrorEnum error) {
        return fail(error.getErrorCode(), error.getErrorMsg());
    }

    public static <T> BaseResult<T> makeSuccess(T data) {
        BaseResult<T> result = new BaseResult<T>();
        result.success(data);
        return result;
    }

    public static BaseResult<Void> makeSuccess() {
        BaseResult<Void> result = new BaseResult<Void>();
        result.setSuccess(true);
        return result;
    }

    public static <T> BaseResult<T> makeFail(BaseErrorEnum error) {
        BaseResult<T> result = new BaseResult<T>();
        result.fail(error);
        return result;
    }

    public static <T> BaseResult<T> makeFail(String errorCode, String errorMsg) {
        BaseResult<T> result = new BaseResult<T>();
        result.fail(errorCode, errorMsg);
        return result;
    }

    public static <T> BaseResult<T> makeFail(String errorMsg) {
        BaseResult<T> result = new BaseResult<T>();
        result.fail("", errorMsg);
        return result;
    }

    public static <T> BaseResult<T> makeFail(BindingResult bindingResult) {
        BaseResult<T> result = new BaseResult<T>();
        String message = null;
        if (bindingResult.hasErrors()) {
            //如果有多个错误信息,返回第一个
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        result.fail("", message);
        return result;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
            "success=" + success +
            ", data=" + data +
            ", errorCode='" + errorCode + '\'' +
            ", errorMsg='" + errorMsg + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
