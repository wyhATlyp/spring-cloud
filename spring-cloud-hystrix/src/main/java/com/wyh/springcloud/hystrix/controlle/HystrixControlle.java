package com.wyh.springcloud.hystrix.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyh.springcloud.hystrix.client.WithHystrixFeignClient;

@RestController
@RequestMapping("hystrix")
public class HystrixControlle {
	
	private int sum;
	
	@Autowired
	private WithHystrixFeignClient withHystrixFeignClient;
	
	@GetMapping("add")
	@HystrixCommand(fallbackMethod = "fail")//优先级低于feign.hystrix.enabled=true，要想使fail方法被调用需改为false
//	@HystrixCommand(fallbackMethod = "fail", commandProperties = {
//			@HystrixProperty(name="execution.isolation.strategy", value="THREAD")
//    		})
	public int add(int a, int b) {
		sum = a + b;
		return withHystrixFeignClient.add(a, b);
	}
	
	@GetMapping("feign")
	public String feign() {
		return withHystrixFeignClient.feign();
	}
	
	public int fail(int a, int b) {
		return sum;
	}
	
}
