package com.teambuilding.rocket_oneway_5;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;


public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //创建生产者对象
        DefaultMQProducer dmp = new DefaultMQProducer("oneway_producer_group");
        //设置命名空间地址
        dmp.setNamesrvAddr("192.168.187.100:9876");
        //启动生产者
        dmp.start();

        //创建消息对象
        Message message = new Message("oneway_message_topic", "tags", "这是单向消息".getBytes());

        //发送单向消息
        dmp.sendOneway(message);

        //关闭生产者
        dmp.shutdown();
    }
}

