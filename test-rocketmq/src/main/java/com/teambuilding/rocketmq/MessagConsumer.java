package com.teambuilding.rocketmq;


import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;


@Service
@RocketMQMessageListener(topic = "${demo.rocketmq.topic}",
        consumerGroup = "${demo.rocketmq.consumer}",
        // 过滤方式，默认为Tag过滤。
        selectorType = SelectorType.TAG,
        //消费模式，有顺序消费、并发消费。
        consumeMode = ConsumeMode.ORDERLY,
        // 消息模式，有集群消费、广播消费
        messageModel = MessageModel.CLUSTERING,
        //  default″*：过滤值，默认 为全部消费，不过滤。
        selectorExpression = "a"
)
public class MessagConsumer implements RocketMQListener<String> {



    @Override
    public void onMessage(String s) {
        System.out.println(s);
    }
}