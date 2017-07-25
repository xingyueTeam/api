package com.xingyue.domain.base.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xingyue.domain.base.core.StatusCode;

/**
 * 响应父类
 * Created by binbin on 2017/7/23.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Response {
    // api请求类型
    protected String action;
    // 状态码
    protected StatusCode code;
    // 状态信息
    protected String message;
    //参数
    private Object[] args;
    //返回数据
    private Object data;

    public Response() {
        this(null);
    }

    public Response(String action) {
        this.action = action;
        this.code = StatusCode.Success;
        this.message = "操作成功";
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
