package com.example.myrabbitmq.rabbitmq.topic;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/29 22:45
 * @description：
 * @modified By：
 */
public class Recv2 {

    private  static  final String EXCHANGE_NAME="test_exchange_topic";
    private  static  final String QUEUE_NAME="test_queue_topic_2";
    public  static  void  main(String[] args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //绑定队列到交换机转发器
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"good.add");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"good.update");

        channel.basicQos(1);
        //定义消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            //获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String arg = new String(body, "UTF-8");
                System.out.println("msg{2}"+arg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }finally {
                    System.out.println("{2}");
                    //手动回执
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        boolean autoAck=false;//自动应答
        //监听队列
        channel.basicConsume(QUEUE_NAME, autoAck, defaultConsumer);
    }

}
