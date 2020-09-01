package com.wyh.springcloud.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wyh.springcloud.feign.annotation.ExcludeComponent;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
@ExcludeComponent
public class FeignAuthAutoConfiguration {

	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "111111");
    }
	
}
