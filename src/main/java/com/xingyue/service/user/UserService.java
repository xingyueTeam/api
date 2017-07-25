package com.xingyue.service.user;

import com.xingyue.domain.module.user.UserInfo;

import java.util.List;

/**
 * Created by MooreLi on 2017/7/24.
 */
public interface UserService {

    List<UserInfo> listUser(Integer sex, Integer minAge);
}
