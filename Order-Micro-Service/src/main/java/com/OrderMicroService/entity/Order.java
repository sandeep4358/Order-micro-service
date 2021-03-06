package com.OrderMicroService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sande
 *
 */
@Entity
@Table(name = "ORDER_MST")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	@Id
	@GeneratedValue
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
		return "Order [orderID=" + orderID + ", userID=" + userID + ", orderDescription=" + orderDescription
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	
	
}
