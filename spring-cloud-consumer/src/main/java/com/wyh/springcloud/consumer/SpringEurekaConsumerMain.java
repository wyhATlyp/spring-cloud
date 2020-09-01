package com.wyh.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaConsumerMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaConsumerMain.class, args);
	}

}
