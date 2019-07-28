package com.bosssoft.hr.train.chp5.ssm.aspect;

import com.bosssoft.hr.train.chp5.ssm.exception.NoLoginException;
import com.bosssoft.hr.train.chp5.ssm.exception.ParamsException;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.BaseEntity;
import com.bosssoft.hr.train.chp5.ssm.pojo.entity.User;
import com.bosssoft.hr.train.chp5.ssm.utils.Constants;
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
import java.util.Date;
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
     * 插入数据的切点
     */
    @Pointcut(value = "execution(public * com.bosssoft.hr.train.chp5.ssm.dao.*.insert*(..)) || " +
            "execution(public * com.bosssoft.hr.train.chp5.ssm.dao.*.save*(..))")
    public void daoInsertAction(){}

    /**
     * 更新、删除数据的切点
     */
    @Pointcut(value = "execution(public * com.bosssoft.hr.train.chp5.ssm.dao.*.update*(..)) || " +
            "execution(public * com.bosssoft.hr.train.chp5.ssm.dao.*.delete*(..))")
    public void daoUpdateAction(){}

    /**
     * 处理添加的默认值填充
     * @param joinPoint 切点
     * @throws Throwable 异常
     */
    @Before(value = "daoInsertAction()")
    public void doInsertBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes!=null) {
            HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            Object[] args = joinPoint.getArgs();
            for (Object object:args){
                if (object instanceof BaseEntity){
                    autoFillValue(user,1, (BaseEntity) object);
                }
            }
        }else {
            throw new ParamsException("数据添加前，无法获取session导致自动填值发生错误！");
        }
    }

    /**
     * 处理修改或删除的默认值填充
     * @param joinPoint 切点
     * @throws Throwable 异常
     */
    @Before(value = "daoUpdateAction()")
    public void doUpdateBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes!=null) {
            HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            Object[] args = joinPoint.getArgs();
            for (Object object:args){
                if (object instanceof BaseEntity){
                    autoFillValue(user,0, (BaseEntity) object);
                }
            }
        }else {
            throw new ParamsException("数据添加前，无法获取session导致自动填值发生错误！");
        }
    }

    /**
     * 自动填值
     * @param user session 用户对象
     * @param type 插入，或者其他类型
     * @param baseEntity 需更改的实体
     */
    private void autoFillValue(User user, Integer type, BaseEntity baseEntity){
        Date now = new Date();
        if (type == 1){
            baseEntity.setCreatedBy(user.getUserId());
            baseEntity.setCreatedTime(now);
            baseEntity.setVersion(Constants.DEFAULT_VERSION);
            baseEntity.setStatus(Constants.DEFAULT_STATUS);
        }
        baseEntity.setUpdatedBy(user.getUserId());
        baseEntity.setUpdatedTime(now);
    }
}
