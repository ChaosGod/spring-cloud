package com.example.myrabbitmq.rabbitmq.simple;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/25 22:04
 * @description：消费者获取消息
 * @modified By：
 */

public class Recv {

    private  static  final  String QUEUE_NAME ="test_simple_queue";

    public static void oldApi() throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();
        //定义队列的消费者
        QueueingConsumer queueingConsumer=new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,queueingConsumer);
        while (true){
            QueueingConsumer.Delivery delivery=queueingConsumer.nextDelivery();
            String msgString=new String(delivery.getBody());
            System.out.println(msgString);
        }

    }

    public static void newAPi() throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //定义消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            //获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String arg = new String(body, "UTF-8");
                System.out.println(arg);
            }
        };
        //监听队列
        channel.basicConsume(QUEUE_NAME,true,defaultConsumer);
    }

    public  static  void  main(String[] args) throws Exception {

    }

}
