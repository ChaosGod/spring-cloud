package com.user.server.provider.server;

import com.example.client.demo.user.domain.User;
import com.example.client.demo.user.server.UserServer;
import com.user.server.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 20:29
 * @description：
 * @modified By：
 */
@Service("userServer")
public class UserServerImpl implements UserServer {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return  userRepository.findAll();
    }
}
