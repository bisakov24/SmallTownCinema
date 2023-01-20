<template>
    <div class="order-card-container">
        <router-link v-bind:to="{ path: '/order/' + this.order.orderId }">
        <h1 class ="order-number" >Order #{{this.order.orderId}} | Seats: {{this.order.seats}} </h1>
        </router-link>
        
        
    </div>
</template>
<script>
export default {
    name: 'order-card',
    props: ['order']
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.order-number{
    font-size: 1.4vw;
    height: 10%;
    font-family: 'Limelight', cursive;
}


.order-card-container{
    max-width: 22%;
    max-height: auto;
   
    border: 5px double #AD974F;
   
    margin-bottom: 2%;
    
    padding-right: 1%;
    padding-left: 1%;
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
}
</style>