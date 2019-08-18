package com.hystrix.demo.demo;

import org.springframework.scheduling.annotation.Scheduled;
import rx.Observer;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/11 22:08
 * @description：
 * @modified By：
 */
public class FutureDemo {


    public static void main(String[] args) {
        Random random=new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(() -> {
            int value = random.nextInt(200);
            System.out.print(value);
            try {
                Thread.sleep(value);
               return "hello";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "hell";
            }
        });
        try {
            submit.get(100, TimeUnit.MILLISECONDS);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        Single.just("hello word"). //发布数据
                subscribeOn(Schedulers.immediate())  //订阅线程
                .subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {

            }
        });
    }
}
