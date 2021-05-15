package com.OrderMicroService.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.OrderMicroService.controller.OrderController;
import com.OrderMicroService.exception.InvalidHeaderFieldException;

//@Component https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm
//You will have to register this Interceptor with InterceptorRegistry by using WebMvcConfigurerAdapter as shown below −

@Component
public class PreRequestInterceptor implements HandlerInterceptor {
	Logger log = LoggerFactory.getLogger(PreRequestInterceptor.class);

	@SuppressWarnings("deprecation")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		
		if(StringUtils.isEmpty(request.getHeader("order-aut-key"))) {
			log.debug("Invalid Request :- Request does not contain the order-aut-key as header");
			throw new InvalidHeaderFieldException("Invalid Request");
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
