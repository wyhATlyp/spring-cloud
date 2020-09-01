package com.wyh.springcloud.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
public class HystrixController {
	
	@GetMapping("add")
	public int add(int a, int b) {
		return a + b;
	}
	
	@GetMapping("feign")
	public String feign() {
		return "hystrix-feign成功被调用了";
	}

}
