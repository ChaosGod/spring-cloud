package com.person.person.server;

import com.person.person.domain.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/18 12:51
 * @description：
 * @modified By：
 */
@FeignClient(value = "person-service")
public interface PersonServer {

    @PostMapping(value = "/person/save")
    Boolean save(Person user);

    @GetMapping(value = "/person/find/all")
    Collection<Person> findAll();
}
