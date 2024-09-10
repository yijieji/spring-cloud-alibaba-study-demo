package com.teambuilding.rocket_batch_6;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;


public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //创建生产者对象
        DefaultMQProducer dmp = new DefaultMQProducer("batch_producer_group");
        //设置命名空间地址
        dmp.setNamesrvAddr("192.168.187.100:9876");
        //启动生产者
        dmp.start();

        //创建消息对象
        List<Message> messages = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Message message = new Message("batch_message_topic", "tags",( "消息"+i).getBytes());
            messages.add(message);
        }

        //发送单向消息
        dmp.send(messages);
        //关闭生产者
        dmp.shutdown();
    }
}


