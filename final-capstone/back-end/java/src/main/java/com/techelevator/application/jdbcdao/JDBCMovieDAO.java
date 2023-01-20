package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.MovieDAO;
import com.techelevator.application.model.Movie;




@Component
public class JDBCMovieDAO implements MovieDAO {

	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCMovieDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Movie> getAllFeaturedMovies() {
		String query = "SELECT * FROM movies WHERE isFeatured = true";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);

		List<Movie> movies = new ArrayList<>();

		while (rowSet.next()) {
			Movie movie = mapRowToMovie(rowSet);
			movies.add(movie);
		}

		return movies;
	}
	

	@Override
	public List<Movie> getAllMovies() {
		String query = "SELECT * FROM movies";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);

		List<Movie> movies = new ArrayList<>();

		while (rowSet.next()) {
			Movie movie = mapRowToMovie(rowSet);
			movies.add(movie);
		}

		return movies;
	}
	
	@Override
	public Movie getChosenMovie(Integer id) {
		String query = "SELECT * FROM movies WHERE movie_id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		Movie movie = new Movie();
		if(rowSet.next()) {
			movie = mapRowToMovie(rowSet);
		}
		
		return movie;
	}
	
	@Override
	public Movie getMovieByShowtimeId(int id) {
		String query = "SELECT movies.* FROM movies JOIN showtimes ON showtimes.movie_id = movies.movie_id WHERE showtimes.showtime_id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		Movie movie = new Movie();
		if(rowSet.next()) {
			movie = mapRowToMovie(rowSet);
		}
		
		return movie;
		
		
	}
	
	@Override
	public void addMovie(Movie movie) {
		
	String query = "INSERT INTO movies (title, release_date, isfeatured, overview, poster, trailer_id) VALUES (?, ?, ?, ?, ? ,?)";
	jdbcTemplate.update(query, movie.getTitle(), movie.getReleaseDate(), movie.isFeatured(), movie.getOverview(), movie.getPoster(), movie.getTrailerId());
		
		
		
	}
	
	
	@Override
	public void toggleFeaturedMovie(Movie movie) {
		
		if(movie.isFeatured() == true) {
			String query = "UPDATE movies SET isfeatured = 'false' WHERE movie_id = ?";
			jdbcTemplate.update(query, movie.getMovieId());
		} else {
			String query = "UPDATE movies SET isfeatured = 'true' WHERE movie_id = ?";
			jdbcTemplate.update(query, movie.getMovieId());
		}
	}
	
	@Override
	public void deleteMovie(Movie movie) {
		String query = "DELETE FROM movies WHERE movie_id = ?";
		jdbcTemplate.update(query, movie.getMovieId());
	}
	
	
	
	
	private Movie mapRowToMovie(SqlRowSet rowset) {
		Movie movie = new Movie();
		movie.setMovieId(rowset.getInt("movie_id"));
		movie.setTitle(rowset.getString("title"));
		movie.setReleaseDate(rowset.getString("release_date"));
		movie.setFeatured(rowset.getBoolean("isfeatured"));
		movie.setOverview(rowset.getString("overview"));
		movie.setPoster(rowset.getString("poster"));
		movie.setTrailerId(rowset.getString("trailer_id"));

		return movie;
	}

	
}
