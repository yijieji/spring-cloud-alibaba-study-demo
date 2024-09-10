package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.jose4j.lang.JoseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Slf4j
public class AuthApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(AuthApplication.class,args);
        log.info("*****************  认证授权中心启动成功 **************");
    }
}