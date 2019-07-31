package com.user.server.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 20:42
 * @description：
 * @modified By：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServerProviderBootStrap {

    public  static  void main (String[] args){
        SpringApplication.run(UserServerProviderBootStrap.class,args);
    }

}
