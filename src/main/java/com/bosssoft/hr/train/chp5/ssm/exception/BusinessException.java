package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 业务异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class BusinessException extends BaseException
{

    public BusinessException() {
        super(10001L,"业务繁忙...请稍后访问");
    }

    public BusinessException(String message) {
        super(10001L, message);
    }
}
