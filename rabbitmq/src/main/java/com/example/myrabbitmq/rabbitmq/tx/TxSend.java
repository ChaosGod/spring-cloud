package com.example.myrabbitmq.rabbitmq.tx;

import com.example.myrabbitmq.rabbitmq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/30 21:50
 * @description：
 * @modified By：
 */
public class TxSend {

    private  static  final String EXCHANGE_NAME="test_queue_tx";

    public  static  void  main(String[] args) throws Exception {

        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();
        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //声明交换机
        channel.queueDeclare(EXCHANGE_NAME,false,false,false,null);//分发

        try {
            channel.txSelect();
            String msg="goods...";
            channel.basicPublish("",EXCHANGE_NAME,null,msg.getBytes());
            channel.txCommit();
            System.out.println("---send"+msg);
        }catch (Exception e){
            channel.txRollback();
        }

        channel.close();
        connection.close();
        }
}
