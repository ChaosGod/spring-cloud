package com.user.consumer.demo.server;

import com.example.client.demo.user.domain.User;
import com.example.client.demo.user.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 23:21
 * @description：
 * @modified By：
 */
@Service
public class UserServerProxy implements UserServer {

    private static final String providver_server_url = "http://user-server-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Boolean save(User user) {
        User user1 = restTemplate.postForObject(providver_server_url + "/user/save", user, User.class);
        return user1==null?false:true;
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }
}
