package com.bosssoft.hr.train.chp5.ssm.exception;

/**
 * 基础异常
 * @author likang
 * @date 2019/7/25 14:58
 */
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 异常码
     */
    private Long code;
    /**
     * 异常信息
     */
    private String message;

    BaseException(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public Long getCode() {
        return code;
    }
}
