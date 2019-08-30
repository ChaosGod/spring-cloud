package com.example.myrabbitmq.rabbitmq.tx;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/29 22:45
 * @description：
 * @modified By：
 */
public class TxRecv1 {

    private  static  final String QUEUE_NAME="test_queue_tx";
    public  static  void  main(String[] args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //绑定队列到交换机转发器
        channel.basicConsume(QUEUE_NAME,true,new DefaultConsumer(channel){

            //获取到达的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String arg = new String(body, "UTF-8");
                System.out.println("msg{1}"+arg);

            }
        });
    }

}
