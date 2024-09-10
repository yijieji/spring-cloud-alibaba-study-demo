package com.teambuilding.controller;

import com.teambuilding.IPaymentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    /**
     * @DubboReference
     * 1，标记Dubbo的服务引用，消费者贴上此注解，Dubbo服务在程序启动，就会将服务注入到当前这个消费者中
     * 2, Dubbo自动处理远程服务过程
     * 3，透明的远程服务调用，不需要关注细节。调用者直接调用即可
     */
    @DubboReference(version = "1.0")
    private IPaymentService iPaymentService;

    @RequestMapping("/getPayment")
    public String order(){

        String result = iPaymentService.payment(12321);
        return "hello 1.0";

    }

}