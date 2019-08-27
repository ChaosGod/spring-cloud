package com.example.myrabbitmq.rabbitmq.work;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/27 22:33
 * @description：
 * @modified By：
 */
public class Send {

    private  static  final  String QUEUE_NAME ="test_work_queue";
    /**
     *
     * @param args
     * @throws Exception
     */
    public  static  void  main(String[] args) throws Exception {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();


        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        for (int i=0;i<50;i++){
            String msg="测试"+i;

              System.out.println(msg);
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(i*20);

        }
        channel.close();
        connection.close();
        }



}
