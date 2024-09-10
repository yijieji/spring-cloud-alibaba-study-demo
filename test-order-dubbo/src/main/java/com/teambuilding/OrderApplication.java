package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubbo
public class OrderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderApplication.class,args);
        log.info("************** 订单服务启动成功 ************");
    }
}
