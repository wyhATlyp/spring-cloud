package com.wyh.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaProviderMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaProviderMain.class, args);
	}

}
