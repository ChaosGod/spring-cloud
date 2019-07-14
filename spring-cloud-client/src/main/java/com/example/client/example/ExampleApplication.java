package com.example.client.example;

import com.example.client.example.health.MyHealthIndictor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Objects;
import java.util.Set;

@SpringBootApplication
public class ExampleApplication {

	private  final ContextRefresher contextRefresher;

	@Autowired
	public ExampleApplication(ContextRefresher contextRefresher) {
		this.contextRefresher = contextRefresher;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Scheduled(fixedRate = 5*1000,initialDelay = 3* 1000)
	public  void autoRefresh(){
		Set<String> update=contextRefresher.refresh();
		if (!Objects.isNull(update)){
			System.out.printf("[Thread :%s] 當前的配置已经更新，集体%s",Thread.currentThread().getName(),update);
		}
	}


	@Bean
	public MyHealthIndictor myHealthIndictor(){
		return  new MyHealthIndictor();
	}

}
