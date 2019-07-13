package com.example.springcloudconfig.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/13 13:08
 * @description：监听器
 * @modified By：
 */
public class SpringEventDemo {
    public static void main(String[] args) {
        //Annotaion 驱动的spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册监听器

        context.addApplicationListener(new ApplicationListener<MyApplication>() {
            //监听器得到的事件
            @Override
            public void onApplicationEvent(MyApplication applicationEvent) {
                System.out.print(applicationEvent.getSource());

            }
        });
        context.refresh();
        //发布事情
        context.publishEvent(new MyApplication("HELLO WORLD"));
    }

    public static class MyApplication extends ApplicationEvent {

        public MyApplication(Object source) {
            super(source);
        }
    }
}

