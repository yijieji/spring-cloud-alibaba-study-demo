package com.teambuilding.rocket_simple_1;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;


public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //创建生产者对象
        DefaultMQProducer dmp = new DefaultMQProducer("group1");
        //设置命名空间地址
        dmp.setNamesrvAddr("192.168.187.100:9876");
        //启动生产者
        dmp.start();

        for (int i = 0; i < 10; i++) {
            //创建消息对象
            Message message = new Message("testTopic", "tags", ("message content" + i).getBytes());

            SendResult result = dmp.send(message);
            System.out.println("result = " + result);
            String msg = new String(message.getBody());
            System.out.println("yjjmsg = " + msg);
        }
        //关闭生产者
        dmp.shutdown();
    }
}
