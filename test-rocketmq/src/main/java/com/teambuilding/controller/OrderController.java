package com.teambuilding.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class OrderController {


    @Autowired
    private RocketMQTemplate rocketMQTemplate; // 直接注入生产者


    @Value("${demo.rocketmq.topic}")
    private String topic;


    /**
     * 发送消息
     * @param topic 主题
     * @param message 消息
     * @return
     */
    public SendResult sendMessage( String message){
        return rocketMQTemplate.syncSend(topic, message);
    }
}
