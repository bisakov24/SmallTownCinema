<template>
  <div class="order-details">

    <h1 class="heading">Order Details</h1>
    <order-details />
  </div>
</template>

<script>
import OrderDetails from '../components/OrderDetails.vue';

export default {
  name: 'order-details-page',
  components:{
    OrderDetails
   
  },
};

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
.heading{
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