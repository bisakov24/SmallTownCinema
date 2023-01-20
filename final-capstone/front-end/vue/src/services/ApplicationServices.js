/**************************************************************************************
* This file is provided for you to use for any Application services you may create
*
*  If you would prefer a file with a different name for your services, 
*     simply create one 
***************************************************************************************/
import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:8080"
});

const http2 = axios.create({
    baseURL: "http://www.omdbapi.com"
});

const http3 = axios.create({
    baseURL: "https://api.themoviedb.org/"
});

export default{
    getFeaturedMovies(){
        return http.get('/featuredMovies');
    },
    deleteAllSeats(){
        return http.post(`/deleteSeats`);
    },
    createSeats(){
        return http.post(`/seatCreation`);
    },
    addShowtimes(movie){
        return http.post(`/addShowtimes`, movie);
    },
    deleteAllShowtimes(){
        return http.post(`/deleteAllShowtimes`);
    },
    deleteAllOrders(){
        return http.post(`/deleteAllOrders`);
    },
    deleteShowtimes(movie){
        return http.put(`/deleteShowtimes`, movie);
    },
    getShowtimesByMovieId(id){
        return http.get(`/showtimes/${id}`);
    },
    getChosenMovie(id){
        return http.get(`/featuredMovies/${id}`);
    },
    getShowtimesByMovieIdAndDayOfWeek(id, dayofweek){
        return http.get(`/showtimes/${id}/${dayofweek}`);
    },
    bookSeatByShowtimeIdAndSeatName(id, seatName){
        return http.put(`/bookSeat/${id}/${seatName}`);
    },
    getSeatsByShowtimeId(id){
        return http.get(`/seats/${id}`);
    },
    getMovieByShowtimeId(id){
        return http.get(`/movieByShowtime/${id}`);
    },
    getShowtimeByShowtimeId(id){
        return http.get(`/showtime/${id}`);
    },
    getAllOrdersByUsername(username){
        return http.get(`/orders/${username}`);
    },
    getOrderByOrderId(id){
        return http.get(`/order/${id}`);
    },
    addOrder(order){
        return http.post(`/orders`, order);
    },
    addMovie(movie){
        return http.post(`/movies`, movie);
    },
    toggleFeaturedMovie(movie){
        return http.put(`/movies`, movie);
    },
    getAllMovies(){
        return http.get('/movies');
    },
    deleteMovie(movie){
        return http.post(`/deleteMovies`, movie);
    },
    getMovieByTitle(title){
        return http2.get(`/?t=${title}&apikey=ef82f3e6`);
    },
    getMovieBySearch(title){
        return http3.get(`/3/search/movie?api_key=2be22032d17e3033c62bfb2f6d5ccd68&language=en-US&query=${title}&page=1&include_adult=false`);
    },
    getMovieTrailer(movieId){
        return http3.get(`/3/movie/${movieId}/videos?api_key=2be22032d17e3033c62bfb2f6d5ccd68&language=en-US`);
    },

}