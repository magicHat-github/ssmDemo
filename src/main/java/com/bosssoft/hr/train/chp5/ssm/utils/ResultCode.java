package com.bosssoft.hr.train.chp5.ssm.utils;

/**
 * 返回Code值
 * @author likang
 * @date 2019/7/25 14:58
 */
public class ResultCode {

    /**
     * 成功 200
     */
    public static final Integer SUCCESS = 20000;

    /**
     * 未登录异常码
     */
    public static final Integer NO_LOGIN = 11001;
    /**
     * 参数错误异常码
     */
    public static final Integer ERROR_PARAMS = 11002;
    /**
     * 业务繁忙
     */
    public static final Integer BUSINESS_EXCEPTION = 11003;
    /**
     * 删除时异常
     */
    public static final Integer DELETE_BEAN_EXCEPTION = 11004;
    /**
     * 保存时异常
     */
    public static final Integer SAVE_BEAN_EXCEPTION = 11005;
    /**
     * 更新时异常
     */
    public static final Integer UPDATE_BEAN_EXCEPTION = 11006;


    /**
     * 找不到 404
     */
    public static final Integer NO_SEARCH = 404;
    /**
     * 请求方法不支持、GET、POST、PUT、DELETE
     */
    public static final Integer REQUEST_METHOD_NOT_SUPPORT = 405;
    /**
     * 请求类型错误
     */
    public static final Integer HTTP_MEDIA_TYPE_NOT_ACCEPTABLE = 406;
    /**
     * 服务器错误 500
     */
    public static final Integer ERROR_SERVICE = 500;
    /**
     * 空指针
     */
    public static final Integer NPE = 1000;
    /**
     * 类型转换异常
     */
    public static final Integer CLASS_CAST = 1001;
    /**
     * IO异常
     */
    public static final Integer IO = 1002;
    /**
     * 找不到此方法异常
     */
    public static final Integer NO_SUCH_METHOD = 1003;
    /**
     * 数组越界
     */
    public static final Integer INDEX_OUT_OF_BOUNDS = 1004;
    /**
     * 栈溢出
     */
    public static final Integer STACK_OVERFLOW_ERROR = 1005;
    /**
     * 除数不能为0
     */
    public static final Integer ARITHMETIC_EXCEPTION = 1006;
    /**
     * 运行时异常
     */
    public static final Integer RUNTIME_EXCEPTION = 1007;
    /**
     * 其他异常
     */
    public static final Integer EXCEPTION = 1008;
}
