package com.OrderMicroService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.OrderMicroService.exception.InvalidFieldException;
import com.OrderMicroService.dto.OrderDTO;
import com.OrderMicroService.entity.Order;
import com.OrderMicroService.service.OrderService;


@RestController
@RequestMapping("/OrderResource")
public class OrderController {
	Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@RequestMapping(path = "/orders" , method = RequestMethod.POST)
	public Order doOrders(@RequestBody Order order) {
		log.debug("order details from client :: "+order);		
		if ("".equals(order.getUserID())) {
			log.error("UserID cannot be empty :: Please login with the proper loging id");
			throw new InvalidFieldException("UserID cannot be empty :: Please login with the proper loging id");
		}
		log.info("order is saved in the cart");
		return orderService.saveOrder(order);
	}
	
	//@RequestMapping(path="/findAllOrderUserBased", method = RequestMethod.POST)
	@GetMapping("/findAllOrderUserBased/{userID}")
	public List<Order> getAllOrderOfUser(@PathVariable String  userID){
		log.debug("Request {}", userID);
		return orderService.getAllOrderUserBased(userID) ;//getAllOrderUserBase(order.getUser_id());
		//return null;
	}
	
	
	@GetMapping("/findAllOrderUserBasedDTO/{orderID}")
	@Cacheable(value="orderDetails", key = "#orderID")
	public List<OrderDTO> getAllOrderOfUserDTOProjection(@PathVariable String orderID){
		log.debug("testing devtools....");
		return orderService.getAllOrderByDTOProjection(orderID) ;//getAllOrderUserBase(order.getUser_id());
	}
	
	

}
