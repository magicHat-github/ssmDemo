package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 存储数据库异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class SaveBeanException extends BaseException
{

    public SaveBeanException() {
        super(10002L,"保存失败...请重试");
    }

    public SaveBeanException(String message) {
        super(10002L, message);
    }
}
