package com.bosssoft.hr.train.chp5.ssm.aspect;

import com.bosssoft.hr.train.chp5.ssm.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 控制层的日志切面
 * @author likang
 * @date 2019/7/25 16:30
 */
@Aspect
@Component
public class AspectControllerLogs {

    private static Logger logger = LoggerFactory.getLogger(AspectControllerLogs.class);
    private Long startTime;

    /**
     * 控制层切点
     */
    @Pointcut("@annotation(com.bosssoft.hr.train.chp5.ssm.annotation.LogController)")
    public void controllerLog(){}

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes==null){
            throw new BusinessException();
        }
        HttpServletRequest request = attributes.getRequest();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + args);
    }

    @AfterReturning(returning = "result", pointcut = "controllerLog()")
    public void doAfterReturning(Object result) throws Throwable {
        logger.info("RESULT : " + result);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime));
    }
}
