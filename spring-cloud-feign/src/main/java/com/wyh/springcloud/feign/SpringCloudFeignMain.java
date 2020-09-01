package com.wyh.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.wyh.springcloud.feign.annotation.ExcludeComponent;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, value = ExcludeComponent.class))
public class SpringCloudFeignMain {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignMain.class, args);
	}

}
