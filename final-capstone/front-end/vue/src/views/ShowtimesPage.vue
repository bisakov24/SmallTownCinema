<template>
  <div class="showtimes">
    <h1 class="showtimes-heading">Showtimes</h1>
    <showtimes />
  </div>
</template>

<script>
import Showtimes from '../components/Showtimes.vue';
export default {
  name: 'showtimes-page',
  components:{
    Showtimes
  },
};

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
.showtimes-heading{
  font-family: 'Limelight', cursive;
   width: 40%;
    margin: auto;
    padding: 1%;
    color: #AD974F;
    font-size: 35px;
    text-align: center;
}
#nav{
  background-color: #AD974F;
}

</style>