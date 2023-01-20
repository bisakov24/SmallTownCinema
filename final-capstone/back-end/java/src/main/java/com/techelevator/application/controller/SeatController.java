package com.techelevator.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.SeatDAO;
import com.techelevator.application.model.Seat;

@RestController
@CrossOrigin
public class SeatController {
	
	private SeatDAO seatDao;
	
	public SeatController(SeatDAO seatDao) {
		this.seatDao=seatDao;
	}
	
	@RequestMapping(path="/seatCreation", method = RequestMethod.POST)
	public void generateSeats() {
		seatDao.generateSeats();
	}

	@RequestMapping(path="/seats/{id}", method=RequestMethod.GET)
	public List<Seat> getSeatsByShowtimeId(@PathVariable int id){
		return seatDao.getSeatByShowtime(id);
	}
	
	@RequestMapping(path="/bookSeat/{showtimeId}/{seatName}", method = RequestMethod.PUT)
	public void bookSeat(@PathVariable int showtimeId, @PathVariable String seatName) {
		
		seatDao.bookSeat(showtimeId, seatName);
	}
	
	@RequestMapping(path="/deleteSeats", method = RequestMethod.POST)
	public void deleteSeats() {
		seatDao.deleteAllSeats();
	}
}
