package com.wyh.springcloud.hystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wyh.springcloud.hystrix.client.impl.WithHystrixFeignClientImpl;

@FeignClient(name = "SPRING-CLOUD-PROVIDER", fallback = WithHystrixFeignClientImpl.class)//关闭熔断 configuration = DisableHystrixFeignAutoConfiguration.class
public interface WithHystrixFeignClient {
	
	@GetMapping("hystrix/add")
	public int add(@RequestParam int a, @RequestParam int b);
	
	@GetMapping("hystrix/feign")
	public String feign();

}
