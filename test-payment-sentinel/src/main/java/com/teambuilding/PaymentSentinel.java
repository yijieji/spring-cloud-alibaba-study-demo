package com.teambuilding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PaymentSentinel {
    public static void main(String[] args) {
        SpringApplication.run(PaymentSentinel.class,args);
        log.info("************ PaymentSentinelMain8001 启动成功 **********");
    }
}
