package com.OrderMicroService.service;

import java.util.List;

import com.OrderMicroService.entity.Order;

public interface OrderService {

	public Order saveOrder(Order order);
	
	public List<Order> getAllOrderUserBased(String user_id);
	
	public List<Order> getAllOrderByDTOProjection(String userID);

	
}
