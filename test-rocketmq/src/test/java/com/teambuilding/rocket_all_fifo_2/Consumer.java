package com.teambuilding.rocket_all_fifo_2;


import com.teambuilding.pojo.Order;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.ArrayList;
import java.util.List;


public class Consumer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        //创建消费者对象
        DefaultMQPushConsumer dmpc = new DefaultMQPushConsumer("local_consumer_group");
        dmpc.setNamesrvAddr("192.168.126.100:9876");

        dmpc.subscribe("local_message_topic","*");
        //监听topic消息
        dmpc.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
//                    System.out.println("messageExt = " + messageExt);
                    byte[] body = messageExt.getBody();
                    String msg = new String(body);
                    System.out.println("当前队列："+messageExt.getQueueId()+" ,消息："+msg);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        dmpc.start();

        //永远运行下去
        Thread.sleep(Long.MAX_VALUE);
    }
    /**
     * 订单完成流程 ： 订单创建->订单支付->订单完成
     * @return
     */
    public static List<Order> getOrderList(){
        List<Order> orderList = new ArrayList<>();
        //将多个订单的状态打乱
        orderList.add(new Order(1L, "订单创建"));
        orderList.add(new Order(4L, "订单创建"));
        orderList.add(new Order(2L, "订单创建"));
        orderList.add(new Order(1L, "订单支付"));
        orderList.add(new Order(2L, "订单支付"));
        orderList.add(new Order(4L, "订单支付"));
        orderList.add(new Order(1L, "订单完成"));
        orderList.add(new Order(3L, "订单创建"));
        orderList.add(new Order(2L, "订单完成"));
        orderList.add(new Order(3L, "订单支付"));
        orderList.add(new Order(4L, "订单完成"));
        orderList.add(new Order(3L, "订单完成"));
        return orderList;
    }
}
