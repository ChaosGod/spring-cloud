package com.example.springcloudconfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
        /*
        *    SpringApplication application=new SpringApplication(SpringCloudApplication.class);
        application.setWebEnvironment(Boolean.TRUE);
        application.run(args);*/
    }

    @Configurable
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public  static class MyPropertySourceLocator implements PropertySourceLocator{

        @Override
        public PropertySource<?> locate(Environment environment) {
            Map<String,Object> map=new HashMap<>();
            map.put("server.port","8081");
            MapPropertySource mapPropertySource=new MapPropertySource("my-property-source",map);
            return mapPropertySource;
        }
    }
}
