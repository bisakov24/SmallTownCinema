package com.techelevator.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.ShowtimesDAO;
import com.techelevator.application.model.Movie;
import com.techelevator.application.model.Showtimes;

@RestController
@CrossOrigin
public class ShowtimesController {
	
	private ShowtimesDAO showtimesDao;
	
	public ShowtimesController(ShowtimesDAO showtimesDao) {
		this.showtimesDao=showtimesDao;
	}
	
	@RequestMapping(path = "/showtimes/{id}", method = RequestMethod.GET)
	public List<Showtimes> getShowtimesByMovieId(@PathVariable int id){
		return showtimesDao.getShowtimesByMovieId(id); 
	}
	
	@RequestMapping(path = "/showtimes/{id}/{dayofweek}", method = RequestMethod.GET)
	public List<Showtimes> getShowtimesByMovieIdAndDayOfWeek(@PathVariable int id, @PathVariable String dayofweek){
		return showtimesDao.getShowtimesByMovieIdAndDayOfWeek(id, dayofweek); 
	}
	
	@RequestMapping(path = "/showtime/{id}", method = RequestMethod.GET)
	public Showtimes getShowtimeByShowtimeId(@PathVariable int id) {
		return showtimesDao.getShowtimeByShowtimeId(id);
	}
	
	@RequestMapping(path = "/addShowtimes", method = RequestMethod.POST)
	public void addShowtimes(@RequestBody Movie movie) {
		showtimesDao.addShowtimes(movie.getMovieId());
	}
	
	@RequestMapping(path = "/deleteShowtimes", method = RequestMethod.PUT)
	public void deleteShowtimes(@RequestBody Movie movie) {
		showtimesDao.deleteShowtimes(movie.getMovieId());
	}
	
	@RequestMapping(path = "/deleteAllShowtimes", method = RequestMethod.POST)
	public void deleteAllShowtimes() {
		showtimesDao.deleteAllShowtimes();
	}
	
}
