package com.hystrix.demo.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/8 22:23
 * @description：
 * @modified By：
 */
@RestController
public class HystrixDemoController {

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "errorContent",
                    commandProperties = {
            @HystrixProperty(value = "100",name = "execution.isolation.thread.timeoutInMilliseconds")
                    })
    public  String hello(){

        return"hello" ;

    }

    @GetMapping("/hello-world-2")

    public  String hello2(){

        return new HelloWoldCommand().execute();

    }

    public String errorContent(){
        return "fault";
    }


    private class  HelloWoldCommand extends com.netflix.hystrix.HystrixCommand<String>{

        protected  HelloWoldCommand(){
            super(HystrixCommandGroupKey.Factory.asKey("Hello word"),100);
        }

        @Override
        protected String run() throws Exception {
            Random random=new Random();
            int value = random.nextInt(200);
                Thread.sleep(value);
            return "Hello word";
        }

        protected String getFallback(){
            return  HystrixDemoController.this.errorContent();
        }
    }
}
