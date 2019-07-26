package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 业务异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class ParamsException extends BaseException
{

    public ParamsException() {
        super(10010L,"传入参数异常！");
    }

    public ParamsException(String message) {
        super(10010L, message);
    }
}
