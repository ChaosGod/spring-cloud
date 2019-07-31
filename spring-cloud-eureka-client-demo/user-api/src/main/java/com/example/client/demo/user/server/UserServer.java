package com.example.client.demo.user.server;

import com.example.client.demo.user.domain.User;

import java.util.Collection;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 19:49
 * @description：
 * @modified By：
 */
public interface UserServer {

    Boolean save(User user);


    Collection<User> findAll();
}
