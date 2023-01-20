<template>
<div class="background">
  <h1 class="admin-heading">Admin Settings</h1>
  <div class="home">
    <admin />
  </div>
</div>
</template>

<script>
import Admin from '@/components/Admin.vue'
export default {
  name: 'adminPage',
  components:{
    Admin
  },
};
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.admin-heading{
  font-family: 'Limelight', cursive;
    width: 40%;
    margin: auto;
    padding: 1%;
    color: #AD974F;
    font-size: 35px;
    text-align: center;
 
}
.home{
  font-family: 'Limelight', cursive;
  margin: auto;
  padding-top: 0%;
  color: #231F20;
}
.featured-movies{
    width: 40%;
    background-color: #AD974F;
    margin: auto;
    padding: 1%;
    border: 5px double #231F20;
    font-size: 35px;

}

</style>