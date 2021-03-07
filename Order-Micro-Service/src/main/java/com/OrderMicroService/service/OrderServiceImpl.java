package com.OrderMicroService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderMicroService.entity.Order;
import com.OrderMicroService.repostory.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository repository;
	
	@Override
	public Order saveOrder(Order order) {		
		return repository.save(order);
	}

	@Override
	public List<Order> getAllOrder() {		
		return repository.findAll();				
	}

}
