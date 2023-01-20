<template>

    <div class = "order-details-container container text-center">
        <h2 class="order-movie-title">{{this.movie.title}}</h2>
        <img class ="order-movie-poster"  v-if="movie.poster" v-bind:src="movie.poster" />
        <h3 class ="order-theater">Theater: {{this.showtime.theaterId}}</h3>
        <h3 class ="order-dayofweek">Day: {{this.order.showtimeDate}}</h3>
        <h3 class ="order-time">Time: {{this.showtime.startTime}}</h3>
        <h3 class ="order-seats">Seats: {{this.order.seats}}</h3>
        <h3 class ="order-divider">-------------------------------------------------------------------------</h3>
        <h2 class ="order-reciept"><u>Purchase Details</u></h2>
        <h3 class ="order-full-name">Name: {{this.$store.state.user.fullName}}</h3>
        <h3 class ="order-email">Email: {{this.$store.state.user.email}}</h3>
        <h3 class ="order-totalCost">Total Cost: ${{this.order.totalCost}}</h3>
        <img class="venmo" src="https://i.imgur.com/rURgSYh.png" />
        <p class ="venmo-statement"><i>Scan this code in your venmo app to pay</i></p>
        

    
        
        
        

    </div>
    
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'


export default {
    components: {
        
    },
    name:'order-details',
    data(){
        return {
            movie: [],
            order: [],
            showtime: []
        }
    },
    methods:{
       
    },
    created(){
       applicationServices.getOrderByOrderId(this.$route.params.id).then(response => {
           this.order = response.data;
           applicationServices.getMovieByShowtimeId(this.order.showtimeId).then(response => {
               this.movie = response.data;
               applicationServices.getShowtimeByShowtimeId(this.order.showtimeId).then(response => {
               this.showtime = response.data;
       })
           })
       })

       

    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');




.order-details-container{
    color: #AD974F;
}


img.order-movie-poster{
    max-width: 15%;
    height: auto;
  
   

}
h2.order-movie-title{
font-size: 35px;
padding-top: 20px;
font-family: 'Limelight', cursive;
border: 5px double #AD974F;
max-width: 30%;
margin: auto;
margin-bottom: 2%;
padding-bottom: 1%;
text-align: center;
color: #AD974F;
}

.venmo{
    width: 15%;
}



</style>