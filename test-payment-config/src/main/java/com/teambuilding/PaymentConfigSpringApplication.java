package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 订单微服务主启动类
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentConfigSpringApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PaymentConfigSpringApplication.class,args);
        log.info("******************** 配置微服务启动成功 ***************");
    }
}


