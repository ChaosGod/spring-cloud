package com.user.consumer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 20:42
 * @description：
 * @modified By：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserConsumerBootStrap {


    public  static  void main (String[] args){
        SpringApplication.run(UserConsumerBootStrap.class,args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
