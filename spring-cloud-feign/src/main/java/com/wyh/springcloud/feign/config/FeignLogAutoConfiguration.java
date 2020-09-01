package com.wyh.springcloud.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wyh.springcloud.feign.annotation.ExcludeComponent;

import feign.Logger;

@Configuration
@ExcludeComponent
public class FeignLogAutoConfiguration {
	
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

}
