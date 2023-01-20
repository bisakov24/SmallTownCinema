<template>
  <div>
    <h1 class="seats-heading">{{this.movie.title}}</h1>
    <div class="seats-tickets">
      <div class="seats">
        <seats />
      </div>
     <!-- <div class="tickets">
        <tickets />
      </div>-->
    </div>
   
  </div>
</template>

<script>
import Seats from '../components/Seats.vue';
import applicationServices from '@/services/ApplicationServices.js'
//import Tickets from '../components/Tickets.vue';

export default {
  name: 'showtimes-page',
  components:{
    Seats,
    //Tickets
  },
  data(){
        return {
          movie: []
        }
  },
  created(){
    applicationServices.getMovieByShowtimeId(this.$route.params.id).then(response => {
          this.movie = response.data;
      })
  },
};

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
.seats-heading{
  font-family: 'Limelight', cursive;
   width: 40%;
    margin: auto;
    padding: 1%;
    color: #AD974F;
    font-size: 35px;
    text-align: center;
}



</style>