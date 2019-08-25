package com.person.client.person.controller;

import com.person.person.domain.Person;
import com.person.person.server.PersonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/18 13:29
 * @description：
 * @modified By：
 */
@RestController
public class PersonClinetController  implements  PersonServer{

    private final PersonServer personServer;

    @Autowired
    public PersonClinetController(PersonServer personServer) {
        this.personServer = personServer;
    }

    @Override
    public Boolean save(@RequestBody  Person user) {
        return personServer.save(user);
    }

    @Override
    public Collection<Person> findAll() {
        return personServer.findAll();
    }
}
