package com.example.myrabbitmq.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/25 21:41
 * @description：
 * @modified By：
 */
public class ConnectionUtils {

    /**
     * 设置Mq的连接
     */

    public static Connection getConnection() throws Exception {
        //定义一个连接共产
        ConnectionFactory factory=new ConnectionFactory();
        //设置服务器地址
        factory.setHost("127.0.0.1");
        //AMQP 5672
        factory.setPort(5672);

        //vhost
        factory.setVirtualHost("/v_host");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("123");
        return factory.newConnection();
    }

}
