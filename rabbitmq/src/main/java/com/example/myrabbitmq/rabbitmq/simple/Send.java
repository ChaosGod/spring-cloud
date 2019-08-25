package com.example.myrabbitmq.rabbitmq.simple;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/25 21:52
 * @description：
 * @modified By：
 */
public class Send {

    private  static  final  String QUEUE_NAME ="test_simple_queue";
    public static void main(String[] args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg="hello world";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("-----send");
        channel.close();
        connection.close();


    }

}
