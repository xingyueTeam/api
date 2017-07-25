package com.xingyue.service.user.impl;

import com.xingyue.domain.mapper.UserMapper;
import com.xingyue.domain.module.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xingyue.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MooreLi on 2017/7/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> listUser(Integer sex, Integer minAge) {
        return userMapper.listUser(sex, minAge);
    }
}
