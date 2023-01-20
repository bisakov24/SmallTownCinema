package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Order;

public interface OrderDAO {

	
	public List<Order> getAllOrdersByUsername(String username);
	
	public Order getOrderByOrderId(int id);
	
	public void addOrder(Order order);
	
	public void deleteAllOrders();
}
