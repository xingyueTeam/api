package com.xingyue.domain.base.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by binbin on 2017/7/24.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Request {
    // api请求类型
    protected String action;
    protected Integer uid;
    // 令牌
    protected String token;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getUid() {
        return uid;
    }

    public Request setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
