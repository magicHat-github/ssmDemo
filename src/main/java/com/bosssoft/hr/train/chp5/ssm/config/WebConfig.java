package com.bosssoft.hr.train.chp5.ssm.config;

import com.bosssoft.hr.train.chp5.ssm.intercepor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * MVC配置
 * 目前只配置了登录拦截器
 * @author likang
 * @date 2019/7/28 20:48
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    /**
     * 用来注册拦截器，添加自定义拦截器
     * addPathPatterns 拦截黑名单 -> /**（表示拦截所有请求，/* 只能匹配一层的拦截，例如/test，无法拦截/test/test1）
     * excludePathPatterns 拦截白名单 -> /user/login （登录请求）
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }

    /**
     * 用来配置静态资源的，比如html，js，css，等等
     * @param registry 资源文件注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
