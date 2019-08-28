package com.example.myrabbitmq.rabbitmq.ps;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/28 22:56
 * @description：
 * @modified By：
 */
public class Send {

    private  static  final String EXCHANGE_NAME="test_exchange";
    public  static  void  main(String[] args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");//分发

        String msg="hello world";
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());

        channel.close();
        connection.close();
        }
}
