package com.user.server.provider.repository;

import com.example.client.demo.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/21 20:32
 * @description：
 * @modified By：
 */

@Component
public class UserRepository   {
    private ConcurrentMap<Long , User> userConcurrentMap=new ConcurrentHashMap<>();

    private static  final AtomicLong idGenerator=new AtomicLong(0);

    public Boolean save(User user){
        long incrementAndGet = idGenerator.incrementAndGet();

        user.setId(incrementAndGet);
       return   userConcurrentMap.putIfAbsent(incrementAndGet,user)==null;
    };


    public  Collection<User> findAll(){
       return userConcurrentMap.values();
    };
}
