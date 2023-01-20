package com.techelevator.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.MovieDAO;
import com.techelevator.application.model.Movie;




@RestController
@CrossOrigin
public class MovieController {
	
	private MovieDAO movieDao;
	
	public MovieController(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}
	
	@RequestMapping(path = "/featuredMovies", method = RequestMethod.GET)
	public List<Movie> getAllFeaturedMovies() {
		return movieDao.getAllFeaturedMovies();
	}
	
	@RequestMapping(path = "/movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

	@RequestMapping(path = "/featuredMovies/{id}", method = RequestMethod.GET)
	public Movie getChosenMovie(@PathVariable Integer id) {
		return movieDao.getChosenMovie(id);
	}
	
	@RequestMapping(path = "/movieByShowtime/{id}", method = RequestMethod.GET)
	public Movie getMovieByShowtimeId(@PathVariable int id) {
		return movieDao.getMovieByShowtimeId(id);
	}
	
	@RequestMapping(path = "/movies", method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie) {
		movieDao.addMovie(movie);
	}
	
	@RequestMapping(path = "/movies", method = RequestMethod.PUT)
	public void toggleFeaturedMovie(@RequestBody Movie movie) {
		movieDao.toggleFeaturedMovie(movie);
	}
	
	@RequestMapping(path = "/deleteMovies", method = RequestMethod.POST)
	public void deleteMovie(@RequestBody Movie movie) {
		movieDao.deleteMovie(movie);
	}
	
	
}
