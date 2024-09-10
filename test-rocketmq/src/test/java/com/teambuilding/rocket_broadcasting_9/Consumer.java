package com.teambuilding.rocket_broadcasting_9;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;

import java.util.List;


public class Consumer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        //创建消费者对象
        DefaultMQPushConsumer dmpc = new DefaultMQPushConsumer("cluster_consumer_group");
        dmpc.setNamesrvAddr("192.168.187.100:9876");

        dmpc.subscribe("cluster_message_topic","*");
        //设置消息模式(广播模式)
        dmpc.setMessageModel(MessageModel.BROADCASTING);
        //监听topic消息
        dmpc.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    byte[] body = messageExt.getBody();
                    String msg = new String(body);
                    System.out.println("msg = " + msg);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        dmpc.start();

        //永远运行下去
        Thread.sleep(Long.MAX_VALUE);
    }
}
