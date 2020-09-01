package com.wyh.springcloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.wyh.springcloud.feign.bean.User;
import com.wyh.springcloud.feign.config.FeignContractAutoConfigiration;
import com.wyh.springcloud.feign.config.FeignLogAutoConfiguration;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "SPRING-CLOUD-PROVIDER", 
	configuration = {FeignContractAutoConfigiration.class, FeignLogAutoConfiguration.class})//configuration属性：自定义时用
public interface ProviderClient {

	@RequestLine("GET feign/get-string/{id}")//contract为Contract.Default()时可用
	public String getString(@Param("id") int id);
	
	/**
	 * 接口参数为java对象时，@RequestMapping method域无效，无论怎么写都是发送post请求
	 * @param user
	 * @return
	 */
	@RequestLine("GET feign/get-user")
	public User getUser(User user);
	
}
