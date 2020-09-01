package com.wyh.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "SPRING-CLOUD-PROVIDER", configuration = CustomRibbonConfig.class)//自定义负载均衡算法时用
public class SpringEurekaRibbonConsumerMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaRibbonConsumerMain.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
