package com.xingyue.domain.base.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xingyue.domain.base.core.StatusCode;
import com.xingyue.domain.base.exception.FailCodeException;
import com.xingyue.domain.base.request.Request;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by binbin on 2017/7/23.
 */
@Aspect
@Configuration
public class ValidParamAspect {
    @Autowired
    private ObjectMapper objectMapper;

    Logger logger = Logger.getLogger("ValidParamAspect");

    String getParamError(List<FieldError> fieldErrorList) {
        StringBuffer stringBuffer = new StringBuffer();
        fieldErrorList.forEach(item -> stringBuffer.append(String.format("field:[%1$s],description:[%2$s],rejected:'%3$s'.",
                item.getField(), item.getDefaultMessage(), item.getRejectedValue())));
        return stringBuffer.toString();
    }

    private void validBindingResult(BindingResult result) throws Exception {
        if (result.hasErrors()) {
            FailCodeException e = new FailCodeException(StatusCode.Param_Error, getParamError(result.getFieldErrors()));
            if (result.getTarget() instanceof Request) {
                ((Request) result.getTarget()).getAction();
                e.setAction(((Request) result.getTarget()).getAction());
            }
            throw e;
        }
    }

    /**
     * 切点【ValidParam注解定义处】
     */
    @Pointcut("execution(* com.xingyue.web.*.*Controller.*(..))")
    public void validParam() {
    }

    @Around("validParam()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        logger.info("Request ====>url: " + url);

//        Object args[] = pjp.getArgs();
//        for (Object arg : args) {
//            if (arg instanceof Request) {
//                Request params = (Request) arg;
//                logger.info("Requested Action=" + pjp.getSignature().toShortString());
//                Map map = objectMapper.readValue(this.objectMapper.writeValueAsString(params), Map.class);
//                logger.info("Requested Param=" + map);
//            }
//        }
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        String s = objectMapper.writeValueAsString(result);
        logger.info("Response ====> " + s);
        return result;
    }

    /**
     * 验证Web请求的参数，是否正确
     * 使用@Before进行前置通知声明，其中value用于定义切入点表达式或引用命名切入点
     *
     * @param joinPoint
     * @throws Exception
     */
    @Before(value = "validParam()")
    public void validParamAccess(JoinPoint joinPoint) throws Exception {
        Object[] objects = joinPoint.getArgs();
        for (Object param : objects) {
            if (param instanceof Request) {
                Request request = (Request) param;
                //TODO 输出日志
//                logger.info("Requested Action ====> " + joinPoint.getSignature().toShortString());
                logger.info("Params ====> " + this.objectMapper.writeValueAsString(request));
            } else if (BindingResult.class.isInstance(param)) {
                //验证参数
                this.validBindingResult((BindingResult) param);
            }
        }
    }
}
