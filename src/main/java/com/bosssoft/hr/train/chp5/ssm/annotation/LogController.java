package com.bosssoft.hr.train.chp5.ssm.annotation;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 控制层日志切面 注解
 * @author likang
 * @date 2019/7/25 17:28
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LogController {

    /**
     * 控制层的描述
     * @return value
     */
    String value() default "";
}
