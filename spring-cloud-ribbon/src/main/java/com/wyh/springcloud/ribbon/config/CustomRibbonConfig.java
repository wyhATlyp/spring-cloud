package com.wyh.springcloud.ribbon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义Ribbon负载均衡算法
 * 此类不可被@ComponentScan注解扫描到，不可放在@SpringBootApplication注解下
 */
@Configuration
public class CustomRibbonConfig {
	
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}

}
