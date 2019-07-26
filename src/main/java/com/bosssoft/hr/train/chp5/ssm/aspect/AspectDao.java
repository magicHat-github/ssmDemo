package com.bosssoft.hr.train.chp5.ssm.aspect;

import com.bosssoft.hr.train.chp5.ssm.exception.NoLoginException;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Dao固定参数 添加
 * @author likang
 * @date 2019/7/26 11:32
 */
@Aspect
@Component
public class AspectDao {

    private static Logger logger = LoggerFactory.getLogger(AspectServiceLogs.class);

    /**
     * 日志切点
     */
    @Pointcut(value = "execution(public * com.bosssoft.hr.train.chp5.ssm.dao.*.save*(..))")
    public void daoInsertAction(){}

    @Before(value = "daoInsertAction()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (servletRequestAttributes!=null) {
//            HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
//            HttpSession session = httpServletRequest.getSession();
//            User user = (User) session.getAttribute("user");
//            if (user == null){
//                throw new NoLoginException();
//            }
//            List<Object> args = Arrays.asList(joinPoint.getArgs());
//            for (Object object:args){
//                if ()
//            }
//        }
    }
}
