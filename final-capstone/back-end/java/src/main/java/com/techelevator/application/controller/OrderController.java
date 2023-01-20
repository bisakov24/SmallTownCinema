package com.techelevator.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.OrderDAO;
import com.techelevator.application.model.Order;

@RestController
@CrossOrigin
public class OrderController {

	private OrderDAO orderDao;
	
	public OrderController(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
	
	@RequestMapping(path = "/orders/{username}", method = RequestMethod.GET)
	public List<Order> getAllOrdersByUsername(@PathVariable String username) {
		return orderDao.getAllOrdersByUsername(username);
	}
	
	@RequestMapping(path = "/order/{id}", method = RequestMethod.GET)
	public Order getOrderByOrderId(@PathVariable int id) {
		return orderDao.getOrderByOrderId(id);
	}
	
	@RequestMapping(path = "/orders", method = RequestMethod.POST)
	public void addOrder(@RequestBody Order order) {
		orderDao.addOrder(order);
	}
	
	@RequestMapping(path = "/deleteAllOrders", method = RequestMethod.POST)
	public void deleteAllOrders() {
		orderDao.deleteAllOrders();
	}
	
}
