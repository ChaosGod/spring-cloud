package com.example.client.demo.user.server;

import com.example.client.demo.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 19:49
 * @description：
 * @modified By：
 */
public interface UserServer {


    Boolean save(@RequestBody  User user);


    Collection<User> findAll();
}
