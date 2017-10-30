package com.keji.blog.result;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
public enum BaseErrorEnum {

    /** 系统错误 */
    SYSTEM_ERROR("500","系统错误"),

    /** 参数错误 */
    PARAM_ERROR("400", "参数错误"),

    /** 参数校验失败 */
    VALIDATE_PARAM_ERROR("401", "参数校验发生异常"),

    /** 权限不足 */
    FORBIDDEN("403","权限不足") ;

    private String errorCode;

    private String errorMsg;

    private BaseErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
