package com.wyh.springcloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class ProviderController {
	
	@Autowired
	private ServerProperties serverProperties;
	
	@GetMapping("{id}")
	public String provider(@PathVariable long id) {
		System.out.println("服务提供者被调用了" + serverProperties.getPort());
		return "提供者" + id + "端口号-" + serverProperties.getPort();
	}

}
