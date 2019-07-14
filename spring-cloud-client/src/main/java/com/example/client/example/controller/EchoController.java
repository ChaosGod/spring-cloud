package com.example.client.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/14 16:32
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping(value = "/name")
@RefreshScope
public class EchoController {


    @Value("${my.name}")
    private String name;

    @RequestMapping(value = "/my")
    public String getEchoName(){

        return  name;
    }
}
