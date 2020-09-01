package com.wyh.springcloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wyh.springcloud.feign.config.FeignAuthAutoConfiguration;
import com.wyh.springcloud.feign.config.FeignLogAutoConfiguration;

/**
 * 通过http://localhost:8761/eureka/apps/SPRING-CLOUD-FEIGN演示：
 * 	1.@FeignClient url属性
 * 		不经过eureka直接请求url
 * 		含有url属性时name属性无效,但必须含有name属性
 * 	2.自定义配置配中加入用户名和密码
 */
@FeignClient(name = "invalid", 
	url = "http://localhost:8761/eureka/", 
	configuration = {FeignAuthAutoConfiguration.class, FeignLogAutoConfiguration.class})
public interface FooEurekaClient {
	
	@GetMapping("apps/{app}")
	public String getApp(@PathVariable String app);

}
