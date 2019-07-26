package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 业务异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class NoLoginException extends BaseException
{

    public NoLoginException() {
        super(10000L,"未登录...请登录");
    }

    public NoLoginException(String message) {
        super(10000L, message);
    }
}
