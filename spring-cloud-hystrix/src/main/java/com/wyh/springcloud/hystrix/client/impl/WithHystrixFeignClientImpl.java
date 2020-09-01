package com.wyh.springcloud.hystrix.client.impl;

import org.springframework.stereotype.Component;

import com.wyh.springcloud.hystrix.client.WithHystrixFeignClient;

@Component
public class WithHystrixFeignClientImpl implements WithHystrixFeignClient {

	@Override
	public int add(int a, int b) {
		return 0;
	}

	@Override
	public String feign() {
		return "feign发生了熔断";
	}

}
