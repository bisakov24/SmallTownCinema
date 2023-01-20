<template>
    <div class="movie-card">
        <router-link class="movie-title" v-bind:to="{ path: '/showtimes/' + this.movie.movieId }">
        <img id="movie-poster" class ="movie-poster"  v-if="movie.poster" v-bind:src="movie.poster" />
        </router-link>

        <router-link v-bind:to="{ path: '/showtimes/' + this.movie.movieId }">
        <h1 id="movie-title" class ="movie-title" >{{this.movie.title}}</h1>
        </router-link>
        
    </div>
</template>
<script>
export default {
    name: 'movie-card',
    props: ['movie']
}
</script>
<style>
.movie-title{
    font-size: 130%;
    height: 10%;
    max-width: 80%;
    margin: auto;
    color: #8E793E;
    margin-bottom: 20px;
}
#movie-poster{
    max-width: 75%;
    max-height: auto;
    border: 5px double #8E793E;

}
.movie-card{
    max-width: 23%;
    max-height: auto;
    
}
</style>