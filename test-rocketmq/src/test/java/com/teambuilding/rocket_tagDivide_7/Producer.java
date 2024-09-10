package com.teambuilding.rocket_tagDivide_7;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.Arrays;
import java.util.List;


public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //创建生产者对象
        DefaultMQProducer dmp = new DefaultMQProducer("tag_producer_group");
        //设置命名空间地址
        dmp.setNamesrvAddr("192.168.187.100:9876");
        //启动生产者
        dmp.start();

        //创建消息对象
        List<String> tags = Arrays.asList("a", "b", "c", "d");
        for (String tag : tags) {
            Message message = new Message("tag_message_topic", tag,( "消息tag"+tag).getBytes());
            SendResult result = dmp.send(message);
            System.out.println("result = " + result);
        }
        //关闭生产者
        dmp.shutdown();
    }
}
