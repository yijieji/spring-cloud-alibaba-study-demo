package com.teambuilding.service;

import com.teambuilding.IPaymentService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0")
public class PaymentDubboServiceImpl implements IPaymentService {
    @Override
    public String payment(Integer id) {

        System.out.println("支付订单" + id);
        return "支付订单为" + id;
    }
}