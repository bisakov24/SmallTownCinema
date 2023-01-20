<template>
  <div>
    <h1 class="heading">My Orders</h1>
    <div class="my-orders">
    <all-orders />
    </div>
   
  </div>
</template>

<script>
import AllOrders from '@/components/AllOrders.vue'
export default {
  name: 'all-orders-page',
  components:{
  AllOrders
  },
};

</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');
.heading{
  color: #EAEAEA;
  font-family: 'Limelight', cursive;
  font-size: 50px;
  border: 5px double #AD974F;
}
#nav{
  background-color: #AD974F;
}