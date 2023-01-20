package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Showtimes;

public interface ShowtimesDAO {

	public List<Showtimes> getShowtimesByMovieId(int id);
	
	public List<Showtimes> getShowtimesByMovieIdAndDayOfWeek(int id, String dayofweek);
	
	public Showtimes getShowtimeByShowtimeId(int id);

	public void addShowtimes(int movieId);
	
	public void deleteShowtimes(int movieId);
	
	public void deleteAllShowtimes();
	
}
