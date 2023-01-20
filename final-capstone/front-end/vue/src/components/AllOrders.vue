<template>
    <div class ="order-container">
        <order-card v-for="order in this.orders" v-bind:key="order.orderId" v-bind:order="order"/>
    </div>
</template>
<script>
import applicationServices from '@/services/ApplicationServices.js'
import OrderCard from './OrderCard.vue';
export default {
  components: { 
      OrderCard
      
  },
    name:'all-orders',
    data(){
        return {
            movies: [],
            orders: []
        }
    },
    methods:{
      
    },
    created(){
       applicationServices.getAllOrdersByUsername(this.$store.state.user.username).then(response => {
           this.orders = response.data;
           
       })

    }
}
</script>
<style scoped>


.order-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    
}

</style>