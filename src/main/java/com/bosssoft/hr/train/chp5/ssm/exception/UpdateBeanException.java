package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 存储数据库异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class UpdateBeanException extends BaseException
{

    public UpdateBeanException() {
        super(10003L,"更新失败...请重试");
    }

    public UpdateBeanException(String message) {
        super(10003L, message);
    }
}
