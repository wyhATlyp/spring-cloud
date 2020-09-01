package com.wyh.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class RibbonConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("{id}")
	public String consumer(@PathVariable long id) {
		return "消费者" + id + restTemplate.getForObject("http://SPRING-CLOUD-PROVIDER/provider/" + id, String.class);
	}
	
	/**
	 * 测试负载均衡算法
	 * @return
	 */
	@GetMapping("LBAlgorithm")
	public String LBAlgorithm() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("SPRING-CLOUD-PROVIDER");
		String PID = serviceInstance.getServiceId() + "-" + serviceInstance.getInstanceId();
		System.out.println(PID);
		return PID;
	}

}
