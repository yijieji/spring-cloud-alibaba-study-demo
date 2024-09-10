package com.teambuilding.rocket_cluster_8;


import com.teambuilding.pojo.Order;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;

import java.util.ArrayList;
import java.util.List;


public class Consumer1 {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        //创建消费者对象
        DefaultMQPushConsumer dmpc = new DefaultMQPushConsumer("cluster_consumer_group");
        dmpc.setNamesrvAddr("192.168.197.100:9876");

        dmpc.subscribe("cluster_message_topic","*");
        //设置消息模式
        dmpc.setMessageModel(MessageModel.CLUSTERING);
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