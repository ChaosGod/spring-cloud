package com.example.springcloudconfig.demo;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/13 11:53
 * @description：
 * @modified By：
 */
public class ObserverDemo {


    public static void main(String[] args) {

        MyObservable myObservable = new MyObservable();
        //增加订阅者
        myObservable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.print(arg);
            }
        });
        myObservable.setChanged();
        //发布者通知  订阅者是被动感知的（推得模式）
        myObservable.notifyObservers("hello  world");


    }

    public static class MyObservable extends Observable {
        protected synchronized void setChanged() {
            super.setChanged();
        }
    }
}