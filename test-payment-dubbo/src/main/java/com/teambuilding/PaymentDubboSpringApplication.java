package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 支付微服务主启动类
 */
@Slf4j
@EnableDubbo
@SpringBootApplication
@MapperScan("com.teambuilding.mapper")
public class PaymentDubboSpringApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentDubboSpringApplication.class,args);
        log.info("************** 支付微服务启动成功 ************");
    }
}