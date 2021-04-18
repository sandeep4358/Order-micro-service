package com.OrderMicroService.dto;


/**
 * 
 * @author OrderDto basically used for the DTO projection. 
 *
 */
public class OrderDTO {
	int orderID;
	String userID; // as we login the flip-kart each user is provided with some user id
	String orderDescription;
	double price;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderID=" + orderID + ", userID=" + userID + ", orderDescription=" + orderDescription
				+ ", price=" + price + "]";
	}
	
	public OrderDTO(int orderID, String orderDescription, double price) {
		super();
		this.orderID = orderID;
		this.orderDescription = orderDescription;
		this.price = price;
	}	
	
	
}
