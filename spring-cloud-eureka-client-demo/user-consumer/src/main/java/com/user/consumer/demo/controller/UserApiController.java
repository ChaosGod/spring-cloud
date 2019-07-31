package com.user.consumer.demo.controller;

import com.example.client.demo.user.domain.User;
import com.example.client.demo.user.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 19:53
 * @description：
 * @modified By：
 */
@RestController
public class UserApiController {


    @Autowired
    private UserServer userServer;

    @PostMapping("/user/save")
    public User addUser( String name){
        User user=new User();
        user.setName(name);
        userServer.save(user);

        return  user;

    }
}
