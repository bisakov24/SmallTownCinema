package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.application.dao.ShowtimesDAO;
import com.techelevator.application.model.Showtimes;

@Component
public class JDBCShowtimesDAO implements ShowtimesDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCShowtimesDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Showtimes> getShowtimesByMovieId(int id) {
		String query = "SELECT * FROM showtimes WHERE movie_id = ?";

		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		List<Showtimes> showtimes = new ArrayList<>();
		
		while (rowSet.next()) {
			Showtimes showtime = mapRowToShowtimes(rowSet);
			showtimes.add(showtime);
		}
		
		return showtimes;
		
		
	}
	
	@Override
	public void addShowtimes(int movieId) {
		String query = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '7:00 PM', 'Friday', false)";
		jdbcTemplate.update(query, movieId);
		
		String query2 = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '7:00 PM', 'Saturday', false)";
		jdbcTemplate.update(query2, movieId);
		
		String query3 = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '5:30 PM', 'Sunday', false)";
		jdbcTemplate.update(query3, movieId);
		
		String query4 = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '6:00 PM', 'Monday', false)";
		jdbcTemplate.update(query4, movieId);
		
		String query5 = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '6:00 PM', 'Tuesday', false)";
		jdbcTemplate.update(query5, movieId);
		
		String query6 = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '6:00 PM', 'Wednesday', false)";
		jdbcTemplate.update(query6, movieId);
		
		String query7 = "INSERT INTO showtimes (movie_id, theater_id, start_time, dayOfWeek, matinee) VALUES (?, 1, '6:00 PM', 'Thursday', false)";
		jdbcTemplate.update(query7, movieId);
		
		
	}
	
	@Override
	public void deleteShowtimes(int movieId) {
		String query = "DELETE FROM showtimes WHERE movie_id = ?";
		jdbcTemplate.update(query, movieId);
	}
	
	@Override
	public void deleteAllShowtimes() {
		String query = "DELETE FROM showtimes";
		jdbcTemplate.update(query);
		String query2 = "alter sequence seq_showtime_id restart with 1";
		jdbcTemplate.update(query2);
	}
	
	
	@Override
	public List<Showtimes> getShowtimesByMovieIdAndDayOfWeek(int id, String dayofweek) {
		String query = "SELECT * FROM showtimes WHERE movie_id = ? AND dayofweek = ?";

		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id, dayofweek);
		
		List<Showtimes> showtimes = new ArrayList<>();
		
		while (rowSet.next()) {
			Showtimes showtime = mapRowToShowtimes(rowSet);
			showtimes.add(showtime);
		}
		
		return showtimes;
		
		
	}
	
	@Override
	public Showtimes getShowtimeByShowtimeId(int id) {
		String query = "SELECT * FROM showtimes WHERE showtime_id = ?";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		Showtimes showtime = new Showtimes();
		
		if (rowSet.next()) {
			showtime = mapRowToShowtimes(rowSet);
			
		}
		
		return showtime;
	}
	
	
	private Showtimes mapRowToShowtimes(SqlRowSet rowset) {
		Showtimes showtimes = new Showtimes();
		
	    showtimes.setShowtimeId(rowset.getInt("showtime_id"));
		showtimes.setMovieId(rowset.getInt("movie_id"));
		showtimes.setTheaterId(rowset.getInt("theater_id"));
		showtimes.setStartTime(rowset.getString("start_time"));
		showtimes.setDayofweek(rowset.getString("dayofweek"));
		showtimes.setMatinee(rowset.getBoolean("matinee"));

		return showtimes;
	}
	
}
