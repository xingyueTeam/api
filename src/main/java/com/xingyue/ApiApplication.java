package com.xingyue;

import com.xingyue.domain.base.core.StatusCode;
import com.xingyue.domain.base.exception.FailCodeException;
import com.xingyue.domain.base.request.Response;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@MapperScan(basePackages = "com.xingyue.domain.mapper")
public class ApiApplication {
    private static Logger logger = Logger.getLogger(ApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public Response indexGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        throw new FailCodeException(StatusCode.API_Fail);
    }

    @RequestMapping(value = "/**", method = RequestMethod.POST)
    public Response indexPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        throw new FailCodeException(StatusCode.API_Fail);
    }
}
