package com.xingyue.web.user;

import com.xingyue.domain.base.request.Response;
import com.xingyue.domain.module.TestRequest;
import com.xingyue.domain.module.user.UserInfo;
import com.xingyue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MooreLi on 2017/7/24.
 */
@RestController
@RequestMapping(value = "userReport")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "listUser", method = RequestMethod.POST)
    Response listUser(@RequestBody TestRequest request) {
        Response result = new Response();
        List<UserInfo> userInfos = userService.listUser(request.getSex(), request.getMinAge());
        result.setData(userInfos);
        return result;
    }
}
