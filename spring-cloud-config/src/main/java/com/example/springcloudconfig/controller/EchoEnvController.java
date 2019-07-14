package com.example.springcloudconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/13 20:56
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping(value = "/encho")
public class EchoEnvController {

    private final Environment environment;

    @Autowired
    public EchoEnvController(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/env/{name}")
    public  String env(@PathVariable String  name){

        return environment.getProperty(name);
    }

}
