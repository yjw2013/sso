package com.sso.domain.result;

import com.sso.domain.BaseDomain;

/**
 * result类
 */
public class SSOResult<T> extends BaseDomain {
    private static final long serialVersionUID = 8924955624084342610L;

    private boolean success = Boolean.TRUE;

    private String errorCode = "";

    private String errorMSG = "";

    private String errorDetailMSG = "";

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMSG() {
        return errorMSG;
    }

    public void setErrorMSG(String errorMSG) {
        this.errorMSG = errorMSG;
    }

    public String getErrorDetailMSG() {
        return errorDetailMSG;
    }

    public void setErrorDetailMSG(String errorDetailMSG) {
        this.errorDetailMSG = errorDetailMSG;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
