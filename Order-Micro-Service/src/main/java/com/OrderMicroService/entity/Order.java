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
	int order_id;
	String order_descrition;
	double price;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_descrition() {
		return order_descrition;
	}
	public void setOrder_descrition(String order_descrition) {
		this.order_descrition = order_descrition;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_descrition=" + order_descrition + ", price=" + price + "]";
	}
	
	
}
