package com.person.server.provider.controller;

import com.person.person.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/18 13:46
 * @description：
 * @modified By：
 */
@RestController
public class PersonServerProiderController {

    private ConcurrentMap<Long , Person> personConcurrentMap=new ConcurrentHashMap<>();

    @PostMapping(value = "/person/save")
 public     Boolean save(@RequestBody Person user){
        return  personConcurrentMap.putIfAbsent(user.getId(),user)==null;
    };

    @GetMapping(value = "/person/find/all")
    public     Collection<Person> findAll(){
        return  personConcurrentMap.values();
    };

}
