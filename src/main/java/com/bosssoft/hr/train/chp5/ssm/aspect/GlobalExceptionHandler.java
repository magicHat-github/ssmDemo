package com.bosssoft.hr.train.chp5.ssm.aspect;

import com.bosssoft.hr.train.chp5.ssm.exception.*;
import com.bosssoft.hr.train.chp5.ssm.pojo.vo.AjaxResult;
import com.bosssoft.hr.train.chp5.ssm.utils.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 统一异常处理类
 * @author likang
 * @date 2019/7/28 19:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 业务异常处理

    /**
     * 未登录异常处理
     * @param ex 未登录异常
     * @return 响应
     */
    @ExceptionHandler(NoLoginException.class)
    @ResponseBody
    public AjaxResult noLoginExceptionHandler(NoLoginException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.NO_LOGIN, ex.getMessage());
    }

    /**
     * 参数错误异常处理
     * @param ex 参数错误异常
     * @return 响应
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public AjaxResult businessException(BusinessException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.BUSINESS_EXCEPTION, ex.getMessage());
    }

    /**
     * 删除时异常处理
     * @param ex 删除异常
     * @return 响应
     */
    @ExceptionHandler(DeleteBeanException.class)
    @ResponseBody
    public AjaxResult deleteBeanException(DeleteBeanException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.DELETE_BEAN_EXCEPTION, ex.getMessage());
    }
    /**
     * 保存时异常处理
     * @param ex 保存时异常
     * @return 响应
     */
    @ExceptionHandler(SaveBeanException.class)
    @ResponseBody
    public AjaxResult saveBeanException(SaveBeanException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.SAVE_BEAN_EXCEPTION, ex.getMessage());
    }
    /**
     * 更新时异常处理
     * @param ex 更新时异常
     * @return 响应
     */
    @ExceptionHandler(UpdateBeanException.class)
    @ResponseBody
    public AjaxResult updateBeanException(UpdateBeanException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.UPDATE_BEAN_EXCEPTION, ex.getMessage());
    }
    /**
     * 参数错误异常处理
     * @param ex 未登录异常
     * @return 响应
     */
    @ExceptionHandler(ParamsException.class)
    @ResponseBody
    public AjaxResult paramsExceptionHandler(ParamsException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.ERROR_PARAMS, ex.getMessage());
    }

    // 下面是系统基本异常处理

    /**
     * 空指针异常
     * @param ex 空指针异常
     * @return JSON响应
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public AjaxResult nullPointerExceptionHandler(NullPointerException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.NPE, ex.getMessage());
    }

    /**
     * 类型转换异常
     * @param ex 类型转换异常
     * @return JSON响应
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public AjaxResult classCastExceptionHandler(ClassCastException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.CLASS_CAST, ex.getMessage());
    }

    /**
     * IO异常
     * @param ex IO异常
     * @return JSON响应
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public AjaxResult ioExceptionHandler(IOException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.IO, ex.getMessage());
    }

    /**
     * 未知方法异常
     * @param ex 未知方法异常
     * @return JSON响应
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public AjaxResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.NO_SUCH_METHOD, ex.getMessage());
    }

    /**
     * 数组越界异常
     * @param ex 数组越界异常
     * @return JSON响应
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public AjaxResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.INDEX_OUT_OF_BOUNDS, ex.getMessage());
    }

    /**
     * 400错误
     * @param ex 400错误
     * @return JSON响应
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public AjaxResult requestNotReadable(HttpMessageNotReadableException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.NO_SEARCH, ex.getMessage());
    }

    /**
     * 400错误
     * @param ex 400错误
     * @return JSON响应
     */
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public AjaxResult requestTypeMismatch(TypeMismatchException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.NO_SEARCH, ex.getMessage());
    }

    /**
     * 400错误
     * @param ex 400错误
     * @return JSON响应
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public AjaxResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.NO_SEARCH, ex.getMessage());
    }

    /**
     * 405错误
     * @param ex 405错误
     * @return JSON响应
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public AjaxResult request405(HttpRequestMethodNotSupportedException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.REQUEST_METHOD_NOT_SUPPORT, ex.getMessage());
    }

    /**
     * 406错误
     * @param ex 406错误
     * @return JSON响应
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public AjaxResult request406(HttpMediaTypeNotAcceptableException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE, ex.getMessage());
    }

    /**
     * 500错误
     * @param ex 500错误
     * @return JSON响应
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public AjaxResult server500(RuntimeException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.ERROR_SERVICE, ex.getMessage());
    }

    /**
     * 栈溢出
     * @param ex 栈溢出
     * @return JSON响应
     */
    @ExceptionHandler({StackOverflowError.class})
    @ResponseBody
    public AjaxResult requestStackOverflow(StackOverflowError ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.STACK_OVERFLOW_ERROR, ex.getMessage());
    }

    /**
     * 除数不能为0
     * @param ex 除数不能为0
     * @return JSON响应
     */
    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public AjaxResult arithmeticException(ArithmeticException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.ARITHMETIC_EXCEPTION, ex.getMessage());
    }

    /**
     *  运行时异常处理类
     * @param ex 产生的异常
     * @return 响应
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public AjaxResult runtimeExceptionHandler(RuntimeException ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.RUNTIME_EXCEPTION, ex.getMessage());
    }

    /**
     * 其他错误
     * @param ex 其他错误
     * @return JSON响应
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public AjaxResult exception(Exception ex) {
        logger.error(ex.getMessage(),ex);
        return AjaxResult.error(ResultCode.EXCEPTION, ex.getMessage());
    }
}
