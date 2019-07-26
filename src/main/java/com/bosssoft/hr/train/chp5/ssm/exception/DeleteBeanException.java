package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 存储数据库异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class DeleteBeanException extends BaseException
{

    public DeleteBeanException() {
        super(10004L,"删除失败...请重试");
    }

    public DeleteBeanException(String message) {
        super(10004L, message);
    }
}
