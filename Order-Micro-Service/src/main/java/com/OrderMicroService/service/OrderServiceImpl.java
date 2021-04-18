package com.OrderMicroService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderMicroService.dto.OrderDTO;
import com.OrderMicroService.entity.Order;
import com.OrderMicroService.repostory.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;

	@Override
	public Order saveOrder(Order order) {
		return repository.save(order);
	}

	@Override
	public List<Order> getAllOrderUserBased(String userId) {
		// TODO Auto-generated method stub
		return repository.findByUserID(userId);
	}

	@Override
	public List<Order> getAllOrderByDTOProjection(String userID) {
		// TODO Auto-generated method stub
		List<OrderDTO> result = repository.getAllOrderDetailsUsingUserIdDTOProjection(userID);
		System.out.println("<----Result fetch from DTO projectoin is--->");
		result.forEach(temp -> {  // use the lambda expression for printing.
			System.out.println(temp);
		});

		return null;
	}

}
