package com.OrderMicroService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.OrderMicroService.entity.Order;
import com.OrderMicroService.service.OrderService;

@RestController

public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(path = "/orders" , method = RequestMethod.POST)
	public Order doOrders(@RequestBody Order order) {
		System.out.println(order);
		return orderService.saveOrder(order);
	}

}
