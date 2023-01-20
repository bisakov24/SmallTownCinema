package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.OrderDAO;
import com.techelevator.application.model.Order;


@Component
public class JDBCOrderDAO implements OrderDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCOrderDAO(DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Order> getAllOrdersByUsername(String username) {
		String query = "SELECT * FROM orders WHERE username = ?";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, username);
		
		List<Order> orders = new ArrayList<>();
		
		while (rowSet.next()) {
			Order order = mapRowToOrder(rowSet);
			orders.add(order);
		}
		return orders;
		
	}
	
	@Override
	public Order getOrderByOrderId(int id) {
		
		String query = "SELECT * FROM orders WHERE order_id = ?";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		Order order = new Order();
		
		if (rowSet.next()) {
			order = mapRowToOrder(rowSet);
		}
		return order;
	}
	
	@Override
	public void addOrder(Order order) {
		
	String query = "INSERT INTO orders (username, showtime_id, seats, total_cost, showtime_date) VALUES (?, ?, ?, ?, ?)";
	jdbcTemplate.update(query, order.getUsername(), order.getShowtimeId(), order.getSeats(), order.getTotalCost(), order.getShowtimeDate());
		
		
		
	}
	
	@Override
	public void deleteAllOrders() {
		String query = "DELETE FROM orders";
		jdbcTemplate.update(query);
		
		String query2 = "alter sequence seq_order_id restart with 1";
		jdbcTemplate.update(query2);
	}
	
	
	
	
	
	
	private Order mapRowToOrder(SqlRowSet rowset) {
		Order order = new Order();
		
		order.setOrderId(rowset.getInt("order_id"));
		order.setUsername(rowset.getString("username"));
		order.setShowtimeId(rowset.getInt("showtime_id"));
		order.setSeats(rowset.getString("seats"));
		order.setTotalCost(rowset.getString("total_cost"));
		order.setShowtimeDate(rowset.getString("showtime_date"));
		
		return order;
	}
	
}
