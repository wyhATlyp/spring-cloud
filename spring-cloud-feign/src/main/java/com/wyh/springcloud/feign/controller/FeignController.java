package com.wyh.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyh.springcloud.feign.bean.User;
import com.wyh.springcloud.feign.client.FooEurekaClient;
import com.wyh.springcloud.feign.client.ProviderClient;

@RestController
@RequestMapping("feign")
public class FeignController {
	
	@Autowired
	private ProviderClient providerClient;
	
	@Autowired
	private FooEurekaClient fooEurekaClient;
	
	@GetMapping("get-string/{id}")
	public String getString(@PathVariable int id) {
		String str = "feign消费者-";
		str += providerClient.getString(id);
		return str;
	}
	
	@GetMapping("get-user/{id}")
	public User getUser(@PathVariable int id) {
		User user = new User();
		user.setId(id);
		user.setAge(18);
		user.setName("消费者");
		user = providerClient.getUser(user);
		return user;
	}
	
	@GetMapping("apps/{app}")
	public String getApp(@PathVariable String app) {
		return fooEurekaClient.getApp(app);
	}

}
