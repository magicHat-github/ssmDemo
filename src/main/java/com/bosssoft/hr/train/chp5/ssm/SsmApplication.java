package com.bosssoft.hr.train.chp5.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序启动类
 * @author likang
 * @date 2019/7/25 14:58
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.bosssoft.hr.train.chp5.ssm.dao")
@EnableAspectJAutoProxy
@SpringBootApplication
public class SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmApplication.class, args);
    }

}
