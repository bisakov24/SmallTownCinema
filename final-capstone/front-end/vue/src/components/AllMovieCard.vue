<template>
    <div class="all-movie-card"> 
        <button class ="movie-button" ><img class ="button-movie-poster"  v-if="movie.poster" v-bind:src="movie.poster" /></button>
        
        <p class="featured-status text-center">Featured: {{this.movie.featured}}</p>  
    </div>
</template>
<script>
export default {
    name: 'all-movie-card',
    props: ['movie']
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.all-movie-card {
    
    display: inline-block;
   
    background-color: #231F20;
   
    
    
}

button.movie-button{
    font-family: 'Open Sans', 'Regular';
    align-content: center;
    background-color: #231F20;
    border: double 5px #AD974F;
    color:#EAEAEA;
}

.movie-button:hover {
    border-color: #fae190;
    border-radius: 4px;
}

.all-movie-card.active .movie-button {
    border-color: #8cda32;
    border-radius: 4px;
}

.movie-button{
    font-size: 16px;
    height: auto;
    width: 298px;
    color: #8E793E;
}

.featured-status{
    color: #EAEAEA;
}

.button-movie-poster{
    width: 276px;
    height: auto;
    
}


</style>