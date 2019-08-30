package com.example.myrabbitmq.rabbitmq.confirm;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/30 22:28
 * @description：
 * @modified By：
 */
public class Send1 {
    private  static  final String QUEUE_NAME="test_queue_confirm_1";
    public  static  void  main(String[] args) throws Exception {

        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();
        //生产者调用confirmSelect 将channel 设置成confirm模式注意
        channel.confirmSelect();
        //声明交换机
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);//分发

        try {
            channel.confirmSelect();
            String msg="goods...";
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("---send"+msg);
        }catch (Exception e){

    }

    if (!channel.waitForConfirms()){
          System.out.println("message send failed");
    }else {
          System.out.println("message send ok ");
    }
        channel.close();
        connection.close();
    }
}

