package com.wyh.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@GetMapping("{id}")
	public String consumer(@PathVariable long id) {
		InstanceInfo instanse = eurekaClient.getNextServerFromEureka("SPRING-CLOUD-PROVIDER", false);
		String url = instanse.getHomePageUrl();
		System.out.println(url);
		return "消费者" + id + restTemplate.getForObject(url + "/provider/" + id, String.class);
	}
	
	@GetMapping("eureka/info")
	public JSONObject eurekaInfo() {
		JSONObject jsonObject = new JSONObject();
		eurekaClient.getApplications().getRegisteredApplications().forEach((l) -> {
			jsonObject.put(l.getName(), l);
		});
	    return jsonObject;
	}

}
