package com.xingyue.domain.module.user;

import java.io.Serializable;

/**
 * Created by MooreLi on 2017/7/24.
 */
public class UserInfo implements Serializable {
    private Integer userId;
    private String userName;
    private Integer age;
    private Integer sex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
