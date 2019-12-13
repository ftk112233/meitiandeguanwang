package com.mt.portalcms.common.exception;

public class LoginException extends RuntimeException {

    public LoginException(int code,String message) {
        super(message);
        this.code = code;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

