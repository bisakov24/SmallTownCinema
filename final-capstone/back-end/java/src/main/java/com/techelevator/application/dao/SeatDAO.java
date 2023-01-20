package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Seat;

public interface SeatDAO {

	public void generateSeats();
	
	public void bookSeat(int showtime_id, String seat_name);
	
	public List<Seat> getSeatByShowtime(int showtimeId);

	public void deleteAllSeats();
	
	
}
