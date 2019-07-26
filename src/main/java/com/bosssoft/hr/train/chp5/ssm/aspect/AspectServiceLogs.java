package com.bosssoft.hr.train.chp5.ssm.aspect;

import com.bosssoft.hr.train.chp5.ssm.annotation.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 业务层的日志切面
 * @author likang
 * @date 2019/7/25 16:30
 */
@Aspect
@Component
public class AspectServiceLogs {

    private static Logger logger = LoggerFactory.getLogger(AspectServiceLogs.class);
    private Long startTime;

    /**
     * 日志切点
     */
    @Pointcut("@annotation(com.bosssoft.hr.train.chp5.ssm.annotation.LogService)")
    public void serviceLog(){}

    /**
     * 方法执行前的记录
     * @param joinPoint 连接点
     * @param logService 切点注解
     * @throws Throwable 异常
     */
    @Before(value = "@annotation(logService)")
    public void doBefore(JoinPoint joinPoint, LogService logService) throws Throwable {
        startTime = System.currentTimeMillis();
        String name = joinPoint.getSignature().getName();
        String str = joinPoint.getSignature().getDeclaringTypeName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (logService!=null){
            logger.info("方法描述: " + logService.value());
        }
        logger.info("执行方法: " + str + "." + name);
        logger.info("传入参数: " + args);
    }

    /**
     * 方法执行后的日志记录
     * @param result 返回值
     * @throws Throwable 异常
     */
    @AfterReturning(returning = "result", pointcut = "serviceLog()")
    public void doAfterReturning(Object result) throws Throwable {
        logger.info("返回结果: " + result);
        logger.info("消耗时长: " + (System.currentTimeMillis() - startTime));
    }

    /**
     * 方法抛出异常时的日志记录
     * @param ex 异常
     */
    @AfterThrowing(pointcut = "serviceLog()",throwing = "ex")
    public void doThrowing(Throwable ex){
        logger.info("抛出异常为: " + ex);
    }

}
