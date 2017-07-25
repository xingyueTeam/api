package com.xingyue.domain.mapper;

import com.xingyue.domain.module.user.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MooreLi on 2017/7/24.
 */
@Repository
public interface UserMapper {

    List<UserInfo> listUser(@Param("sex") Integer sex, @Param("minAge") Integer minAge);
}
