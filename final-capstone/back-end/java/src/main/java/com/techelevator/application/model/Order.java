package com.techelevator.application.model;

public class Order {

	private int orderId;
	private String username;
	private int showtimeId;
	private String seats;
	private String totalCost;
	private String showtimeDate;
	
	public Order() {
		
	}
	
	public Order(int orderId, String username, int showtimeId,
			String seats, String totalCost, String showtimeDate ) {
		
		this.orderId = orderId;
		this.username = username;
		this.showtimeId = showtimeId;
		this.seats = seats;
		this.totalCost = totalCost;
		this.showtimeDate = showtimeDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public String getShowtimeDate() {
		return showtimeDate;
	}

	public void setShowtimeDate(String showtimeDate) {
		this.showtimeDate = showtimeDate;
	}
	
	
	
	
	
	
}
