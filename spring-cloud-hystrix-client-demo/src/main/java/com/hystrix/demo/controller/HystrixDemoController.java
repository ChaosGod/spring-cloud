package com.hystrix.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/8 22:23
 * @description：
 * @modified By：
 */
@RestController
public class HystrixDemoController {

    @GetMapping("hello")
    @HystrixCommand(fallbackMethod = "errorContent",
                    commandProperties = {
            @HystrixProperty(value = "",name = "")
                    })
    public  String hello(){

        return"hello" ;

    }

    public String errorContent(){
        return "fault";
    }
}
