<template>
<div class="background">
  <div class="home">
    <h1 class="featured-movies-header">Featured Movies</h1>
    <featured-movies />
  </div>
</div>
</template>

<script>
import FeaturedMovies from '@/components/FeaturedMovies.vue'
export default {
  name: 'home',
  components:{
    FeaturedMovies
  },
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.home-heading{
  color: #AD974F;
  font-family: 'Limelight', cursive;
  font-size: 40px;
  text-align: center;
}
.home{
  font-family: 'Limelight', cursive;
  margin: auto;
  padding-top: 0%;
  color: #231F20;
}
.featured-movies-header{
    width: 40%;
    margin: auto;
    padding: 1%;
    color: #AD974F;
    font-size: 35px;
    text-align: center;

}

</style>