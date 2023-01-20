<template>
    <div class="tickets-container">
        <h1>Select Tickets</h1>
        <div class="Adult">
            <h2>Adult</h2>
                <div class="counter-buttons">
                    <button v-on:click="incrementAdultCount(), totalTicketCount()">+</button>
                        <h3>{{adultCount}}</h3>
                    <button v-on:click="decrementAdultCount(), totalTicketCount()">-</button>
                </div>
        </div>
        <div class="Child">
            <h2>Child</h2>
                <div class="counter-buttons">
                    <button v-on:click="incrementChildCount(), totalTicketCount()">+</button>
                        <h3>{{childCount}}</h3>
                    <button v-on:click="decrementChildCount(), totalTicketCount()">-</button>
                </div>
        </div>
        <div class="Senior">
            <h2>Senior</h2>
                <div class="counter-buttons">
                    <button v-on:click="incrementSeniorCount(), totalTicketCount() ">+</button>
                        <h3>{{seniorCount}}</h3>
                    <button v-on:click="decrementSeniorCount(), totalTicketCount()">-</button>
                </div>
        </div>
    <div class="total-tickets">
        <h2>Total Tickets</h2>
        <h3>{{totalTickets}}</h3>
    </div>
    </div>
</template>

<script>
export default {
      name: 'tickets',
      data(){
        return {
    adultCount: 0,
    childCount: 0,
    seniorCount: 0,
    totalTickets: 0
        }
    },
    methods: {
        incrementAdultCount(){
            this.adultCount += 1;
        },

         incrementChildCount(){
            this.childCount += 1;
        },

          incrementSeniorCount(){
            this.seniorCount += 1;
        },
         decrementAdultCount(){
             if(this.adultCount > 0) {
             this.adultCount -= 1;
             }
            
        },

         decrementChildCount(){
             if(this.childCount > 0) {
             this.childCount -= 1;
             }
            
        },

          decrementSeniorCount(){
            if(this.seniorCount > 0) {
            this.seniorCount -= 1;
            } 
            
        },
        totalTicketCount() {
            this.totalTickets = this.seniorCount + this.childCount +  this.adultCount;
        }
    }
    
  
}

</script>

<style>
.tickets-container{
    background-color: #EAEAEA;
    color: #231F20;
    border: 5px double #AD974F;
}

</style>