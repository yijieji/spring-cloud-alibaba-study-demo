package com.teambuilding.rocket_all_fifo_2;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;


public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer dmp = new DefaultMQProducer("global_producer_group");
        dmp.setNamesrvAddr("192.168.187.100:9876");
        dmp.start();

        for (int i = 0; i < 10; i++) {
            Message message = new Message("global_message_topic", "tags", ("message content" + i).getBytes());

            SendResult result = dmp.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    return list.get((int) o);
                }
            }, 1);
            System.out.println("result = " + result);


        }
        //关闭生产者
        dmp.shutdown();
    }
}

