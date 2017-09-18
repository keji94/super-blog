package com.keji.blog.result;

/**
 * @Author: wb-ny291824
 * @Description
 * @Date: Created in 2017/9/18
 * @Modified: By:
 */
public enum BaseErrorEnum {
    SYSTEM_ERROR("500","系统错误");
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
