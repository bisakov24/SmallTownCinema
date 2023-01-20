<template>
    <div class ="movie-container">
        <movie-card v-for="movie in this.movies" v-bind:key="movie.title" v-bind:movie="movie"/>
    </div>
</template>
<script>
import applicationServices from '@/services/ApplicationServices.js'
import MovieCard from './MovieCard.vue';
export default {
  components: { 
      MovieCard
      
  },
    name:'featured-movies',
    data(){
        return {
            movies: []
        }
    },
    methods:{
        getFeaturedMovies(){
            applicationServices.getFeaturedMovies().then(response => {
                this.movies = response.data
            });
        }
    },
    created(){
        this.getFeaturedMovies();
    }
}
</script>
<style scoped>
.movie-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    margin-top: 20px;
    text-align: center;
}

</style>