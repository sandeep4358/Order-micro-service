package com.OrderMicroService.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OrderMicroService.dto.OrderDTO;
import com.OrderMicroService.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUserID(String userID);
	
	@Query("Select new com.OrderMicroService.dto.OrderDTO(a.orderID, a.orderDescription, a.price) from Order a where a.userID=:userID ")
	List<OrderDTO> getAllOrderDetailsUsingUserIdDTOProjection(String userID);
	

}
