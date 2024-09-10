package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class OrderHigressApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderHigressApplication.class,args);
        log.info("****************** 订单微服务启动成功 ***********");
    }
}
