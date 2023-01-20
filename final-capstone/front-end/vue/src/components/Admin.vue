<template>
    <div class="container">
        <div class="row">
            <h1 class="all-movies">Change Featured Movies</h1>
        </div>
        <br>
        <div class="row">
            <all-movie-card class="col" v-on:click.native="selectMovie(movie)" v-for="movie in this.movies" v-bind:key="movie.title" v-bind:movie="movie" v-bind:class="{ active: selectedMovie == movie }"/>
        </div>
        <br>
        <div class="row">
            <h2 class="selected-movie-title" v-if="!selectedMovie">Select a movie above</h2>
            <h2 class="selected-movie-title" v-if="selectedMovie">Selected: {{this.selectedMovie.title}}</h2>
        </div>
        <br>
        <div class="row g-3">
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="toggleFeaturedStatus(), reloadPage()">Flip Featured Status</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="addShowtimes(), reloadPage()">Add Movie Showtimes</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="deleteAllShowtimes(), reloadPage()">Delete All Showtimes</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="deleteShowtimes(), reloadPage()">Delete Movie Showtimes</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="deleteMovie(), reloadPage()">Delete Movie</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="deleteAllOrders(), reloadPage()">Delete All Orders</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="deleteAllSeats(), reloadPage()">Delete All Seats</button>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-lg btn-admin m-3" v-on:click="createSeats(), reloadPage()">Create Seats</button>
            </div>
        </div>
        <div class="add-movie-header">
            <h1 class="all-movies">Add Movies</h1><br />
        </div>

        <div class="add-movie-preview">
            <img id="movie-poster" class ="preview-poster"  v-if="searchedMovie" v-bind:src="'https://www.themoviedb.org/t/p/w600_and_h900_bestv2'+ this.searchedMovie.results[0].poster_path" /> <br />
        </div>

        <div class="add-movie-form">
            <form class="movie-form" v-on:submit.prevent="addMovie(); reloadPage()">
                <label for="title">Search Movie By Title:</label><br>

                <form v-on:submit.prevent="getMovieBySearch(movieTitle)">
                    <div class="input-group input-group-lg">
                            <input type="text" name="title" class="form-control checkout-box" aria-label="Search movies" aria-describedby="button-addon2" v-model="movieTitle" required>
                            <button class="btn btn-admin create-seats-button" type="submit" id="button-addon2">Search Movies</button>
                    </div>
                </form>
                <br>

                <label for="title">Title:</label><br>
                <input class="checkout-box" type="text" id="title" v-model="movie.title" required name="title">
                <br><br>

                <label for="release">Release Date:</label><br>
                <input class="checkout-box" type="text" id="release" v-model="movie.releaseDate"  required name="release">
                <br><br>

                <div class="form-check form-switch">
                    <label class="form-check-label" for="featured">Featured</label>
                    <input class="form-check-input" type="checkbox" id="featured" v-model="movie.featured">
                </div>
                <br>

                <label for="overview">Overview:</label><br>
                <input class="checkout-box" type="text" id="overview" v-model="movie.overview" required name="overview">
                <br><br>

                <label for="poster">Poster Link:</label><br>
                <input class="checkout-box" type="text" id="poster" v-model="movie.poster" required name="poster">
                <br><br>

                <label for="trailer">Trailer Link:</label><br>
                <input class="checkout-box" type="text" id="trailer" v-model="movie.trailerId" required name="trailer">
                <br><br>

                <input type="submit" class="btn btn-admin btn-lg" name="add">
                <br><br>
            </form>
        </div>    
    </div>
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import AllMovieCard from './AllMovieCard';
export default {
  components: { 
      AllMovieCard
      
  },
    name:'admin',
    data(){
        return {
            movie: {
                 title: "",
                 releaseDate: "",
                 overview: "",
                 poster: "",
                 trailerId: "",
                 featured: false
             },
            movies: [],
            searchedMovie: "",
            movieTitle: "",
            selectedMovie: "",
            searchedMovieId: "",
            movieTrailerObject: "",
            searchedMovieTwo: "",
            
        }
    },
    methods:{
        getAllMovies(){
            applicationServices.getAllMovies().then(response => {
                this.movies = response.data
            });
        },
        getMovieByTitle(title){
            applicationServices.getMovieByTitle(title).then(response => {
                this.searchedMovieTwo = response.data
                
            })
        },
        getSearchedMovieId(){
            this.searchedMovieId = this.searchedMovie.results[0].id;
        },
        getMovieBySearch(title) {
            applicationServices.getMovieBySearch(title)
                .then(movieSearchResponse => this.searchedMovie = movieSearchResponse.data)
                .then(() => this.searchedMovieId = this.searchedMovie.results[0].id)
                .then(() => applicationServices.getMovieTrailer(this.searchedMovieId))
                .then(trailerSearchResponse => this.movieTrailerObject = trailerSearchResponse.data)
                .then(() => {
                    this.movie.title = this.searchedMovie.results[0].title;
                    this.movie.releaseDate = this.searchedMovie.results[0].release_date;
                    this.movie.overview = this.searchedMovie.results[0].overview;
                    this.movie.poster = 'https://www.themoviedb.org/t/p/w600_and_h900_bestv2'+ this.searchedMovie.results[0].poster_path;
                    this.movie.trailerId = this.movieTrailerObject.results[0].key;
                });
        },
        selectMovie(movie){
                this.selectedMovie = movie
        },
        toggleFeaturedStatus(){
            applicationServices.toggleFeaturedMovie(this.selectedMovie)
        },
        deleteMovie(){
            applicationServices.deleteMovie(this.selectedMovie)
        },
        reloadPage(){
        window.location.reload()
        },
        addMovie() {
            applicationServices.addMovie(this.movie);
        },
        addShowtimes(){
            applicationServices.addShowtimes(this.selectedMovie);
        },
        deleteShowtimes(){
            applicationServices.deleteShowtimes(this.selectedMovie);
        },
        deleteAllShowtimes(){
            applicationServices.deleteAllShowtimes();
        },
        deleteAllOrders(){
            applicationServices.deleteAllOrders();
        },
        deleteAllSeats(){
            applicationServices.deleteAllSeats();
        },
        createSeats(){
            applicationServices.createSeats();
        }
    },
    created(){
        this.getAllMovies();
    }
}
</script>

<style>

.selected-movie-title{
    color: #AD974F;
    text-align: center;
}

.add-movie-form{
    color: #AD974F;
}

.add-movie-preview{
    justify-content: center;
}

.preview-poster{
    width: 20%;
    height: auto;
    margin: auto;
}


.movie-buttons {
    justify-content: center;
    padding-top: 2%;
}

.btn-admin {
  background-color:#AD974F !important;
  border-color: #AD974F !important;
}

.btn-admin:hover {
    background-color:#fdde78 !important;
  border-color: #fdde78 !important;
}

.all-movies{
    width: 40%;
    background-color: #AD974F;
    margin: auto;
    padding: 1%;
    border: 5px double #231F20;
    font-size: 35px;
    margin-top: 5%;
    text-align: center;

}

.movie-form{
    text-align: start;
}

</style>
