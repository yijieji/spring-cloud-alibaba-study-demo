package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 订单微服务主启动类
 */
@Slf4j
@EnableDiscoveryClient//向注册中心注册该服务，并可以获取其他服务的调用地址
@SpringBootApplication
public class OrderSpringApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(OrderSpringApplication.class,args);
        log.info("************** 订单服务启动成功 ************");
    }
}