package com.xingyue.domain.module;

import com.xingyue.domain.base.request.Request;

/**
 * Created by MooreLi on 2017/7/24.
 */
public class TestRequest extends Request{
    private Integer sex;
    private Integer minAge;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }
}
