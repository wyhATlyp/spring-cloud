package com.wyh.springcloud.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wyh.springcloud.feign.annotation.ExcludeComponent;

import feign.Contract;

@Configuration
@ExcludeComponent
public class FeignContractAutoConfigiration {

	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
	
}
