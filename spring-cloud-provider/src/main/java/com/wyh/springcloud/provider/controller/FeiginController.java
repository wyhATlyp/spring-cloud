package com.wyh.springcloud.provider.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyh.springcloud.bean.User;

@RestController
@RequestMapping("feign")
public class FeiginController {
	
	private static Log log = LogFactory.getLog(FeiginController.class);
	
	@GetMapping("get-string/{id}")
	public String getString(@PathVariable int id) {
		String str = "服务提供者" + id;
		log.info(str);
		return str;
	}
	
	@GetMapping("get-user")
	public User user(@RequestBody User user) {
		if(user == null)
			user = new User();
		user.setName("提供者");
		return user;
	}

}
