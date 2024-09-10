package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付微服务主启动类
 */
@Slf4j
@EnableDiscoveryClient//向注册中心注册该服务，并可以获取其他服务的调用地址
@SpringBootApplication
public class PaymentSpringApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentSpringApplication.class,args);
        log.info("************** 支付服务启动成功 ************");
    }
}