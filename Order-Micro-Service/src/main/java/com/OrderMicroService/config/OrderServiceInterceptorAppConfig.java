package com.OrderMicroService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.OrderMicroService.Interceptor.PreRequestInterceptor;

@Component
public class OrderServiceInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	PreRequestInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
