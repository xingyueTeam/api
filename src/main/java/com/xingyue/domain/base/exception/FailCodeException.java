package com.xingyue.domain.base.exception;


import com.xingyue.domain.base.core.StatusCode;

/**
 * 返回失败的Code
 * Created by binbin on 2017/7/23.
 */
public class FailCodeException extends Exception {
    //请求类型
    private String action;
    //状态码
    private StatusCode statusCode;

    public FailCodeException(StatusCode statusCode) {
        this(statusCode, null);
    }

    public FailCodeException(StatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }
}
