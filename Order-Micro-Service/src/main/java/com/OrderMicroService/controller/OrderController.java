package com.OrderMicroService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.OrderMicroService.entity.Order;
import com.OrderMicroService.service.OrderService;

@RestController
@RequestMapping("/OrderResource")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(path = "/orders" , method = RequestMethod.POST)
	public Order doOrders(@RequestBody Order order) {
		System.out.println(order);
		return orderService.saveOrder(order);
	}
	
	//@RequestMapping(path="/findAllOrderUserBased", method = RequestMethod.POST)
	@GetMapping("/findAllOrderUserBased/{userID}")
	public List<Order> getAllOrderOfUser(@PathVariable String  userID){
		return orderService.getAllOrderUserBased(userID) ;//getAllOrderUserBase(order.getUser_id());
		//return null;
	}
	
	@GetMapping("/findAllOrderUserBasedDTO/{orderID}")
	public List<Order> getAllOrderOfUserDTOProjection(@PathVariable String orderID){
		return orderService.getAllOrderByDTOProjection(orderID) ;//getAllOrderUserBase(order.getUser_id());
		//return null;
	}

}
