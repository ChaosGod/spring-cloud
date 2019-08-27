package com.example.myrabbitmq.rabbitmq.workfair;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/27 22:33
 * @description：
 * @modified By：
 */
public class Send {

    private  static  final  String QUEUE_NAME ="test_work_fair_queue";
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
        /**
         * 每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只能处理一个消息
         * 限制发送给同一个消费者不得超过一条信息
         */
        int prefectCount=1;

        channel.basicQos(prefectCount);
        for (int i=0;i<50;i++){
            String msg="测试"+i;

              System.out.println(msg);
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(i*5);

        }
        channel.close();
        connection.close();
        }



}
