<template>
    <div class="seat-ticket-container">


        <div class="container w-55">
        <div class="tickets-container container row">
            <h1 class="ticket-header row justify-content-center">Select Tickets</h1>
            <div class="Adult col text-center">
                <h2 class="adult-header">Adult</h2>
                <div class="counter-buttons">
                    <button class="btn btn-success btn-sm" v-on:click="incrementAdultCount(), totalTicketCount(), getChosenDate()">+</button>
                        <h3>{{adultCount}}</h3>
                    <button class="btn btn-danger btn-sm" v-on:click="decrementAdultCount(), totalTicketCount(), getChosenDate()">-</button>
                </div>
            </div>
            <div class="Child col text-center">
                <h2 class="child-header">Child</h2>
                <div class="counter-buttons">
                    <button class="btn btn-success btn-sm" v-on:click="incrementChildCount(), totalTicketCount(), getChosenDate()">+</button>
                        <h3>{{childCount}}</h3>
                    <button class="btn btn-danger btn-sm" v-on:click="decrementChildCount(), totalTicketCount(), getChosenDate()">-</button>
                </div>
            </div>
            <div class="Senior col text-center">
                <h2 class="senior-header">Senior</h2>
                <div class="counter-buttons">
                    <button class="btn btn-success btn-sm" v-on:click="incrementSeniorCount(), totalTicketCount(), getChosenDate()">+</button>
                        <h3>{{seniorCount}}</h3>
                    <button class="btn btn-danger btn-sm" v-on:click="decrementSeniorCount(), totalTicketCount(), getChosenDate()">-</button>
                </div>
            </div>
            <div class="row">
                <div class="total-tickets col text-center">
                    <h2>Total Tickets</h2>
                    <h3>{{totalTickets}}</h3>
                </div>
                   <div class="total-cost col text-center">
                    <h2>Total Cost</h2>
                    <h3>${{totalCosts.toFixed(2)}}</h3>
                </div>
            </div>    
                <div class="snacks-header row">
                    <h2 class="senior-header text-center"><u>Concessions</u></h2>
                </div>  
                 <div class="snacks-text row">
                    <p class="snacks-disclaimer text-center"><i>One carbonated beverage, one popcorn, and one candy box is included in the purchase of a ticket.</i></p>
                </div>  
             <div class="all-snacks row">
             <div class="salt-vinny col text-center">
                <input type="checkbox" v-model="carbonatedBeverage" v-on:change="addCarbonatedBeverage(), getTotalCost()" class="form-check-input">
                <label class="chip" for="accept">&nbsp;Extra Carbonated Beverage</label>
            </div>
            <div class="jalapeno-cheetos col text-center">
                <input type="checkbox" v-model="popcorn" v-on:change="addPopcorn(), getTotalCost()" class="form-check-input">
                <label class="chip" for="accept">&nbsp;Extra Popcorn</label>
            </div>
             <div class="candy-box col text-center">
                <input type="checkbox" v-model="boxCandy" v-on:change="addBoxCandy(), getTotalCost()" class="form-check-input">
                <label class="chip" for="accept">&nbsp;Extra Box Candy</label>
            </div>
    
            
             </div>    
                
        </div>
        </div>
       
        
        
        <br>
        <div class="container">
        <div class="box row justify-content-center">Screen</div>
        <div class="row justify-content-center">
        <img class="taken-seats w-50" src="https://i.imgur.com/07WDOEc.png" />
       </div>
        </div>

        <br>
        
        <h2 class="available-seats row text-center"><u>Available Seats</u></h2>

        

         

        
        <div class="seats-container col text-center">
            <seat-card class="" v-on:click.native="selectSeats(seat.name), selectedSeatsToString()" v-for="seat in this.seats" v-bind:key="seat.name" v-bind:seat="seat" />
        </div>
       
        
        <br>

        
        
            <br/>
       <div class="selected-box">
            <h2 class="selected-seats row justify-content-center"><u class="row justify-content-center">Selected Seats</u>{{this.selectedSeats.join(', ')}}</h2>
        </div>
            <br>
          <div class="checkout-button-container text-center">
                <button class="btn btn-success"  v-if="!isHidden" :disabled='isDisabled()' v-on:click.prevent="submitOrder(), bookSeats(), isHidden = true" >Checkout</button>
            </div>
            <div class="orders-button-container text-center">
                <br />
                <router-link v-bind:to="{ name: 'myOrders' }">
                <button class="btn btn-warning" v-if = isHidden>My Orders</button>
                </router-link>
            </div>
        
        
        
    </div>
</template>

<script>
import applicationServices from '@/services/ApplicationServices.js'
import SeatCard from './SeatCard.vue'

export default {
    components: {
        SeatCard
    },
    prop: ['seat'],
    name:'seats',
    data(){
        return {
             
             order: {
                 username: this.$store.state.user.username,
                 showtimeId: this.$route.params.id,
                 seats: "",
                 totalCost: 0,
                 showtimeDate: "",
             },
          
            
            selectedCount: 0,
            movie: [],
            showtimes: [],
            seats: [],
            selectedSeats: [],
            adultCount: 0,
            childCount: 0,
            seniorCount: 0,
            totalTickets: 0,
            totalCosts: 0,
            isHidden: false,
            saltAndVinnys: false,
            jalapenoCheetos: false,
            boxCandy: false,
            popcorn: false,
            carbonatedBeverage: false,
            seatsSelected: false,
        }
    },
    methods:{
      incrementAdultCount(){
            if(this.totalTickets < this.seats.length){
            this.adultCount += 1;
            }  
        },
        isDisabled(){
            if(this.selectedCount === 0) {
                return true;
            } else {
                return false;
            }
        },
         incrementChildCount(){
            if(this.totalTickets < this.seats.length) {
            this.childCount += 1;
            }           
        },
          incrementSeniorCount(){
            if(this.totalTickets < this.seats.length) {
            this.seniorCount += 1;
            }
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
            
            
        },
        selectSeats(seatName){
           
            if((this.selectedCount < this.totalTickets) && !this.selectedSeats.includes(seatName)){
               this.selectedSeats.push(seatName);
               this.selectedCount += 1;
            }
            
        },
        checkSeats() {
            if(this.selectedCount > this.totalTickets) {
                this.selectedSeats = [];
                this.selectedCount = 0;
                
            }
        },
        bookSeats(){
            let i;
            for(i = 0; i < this.selectedSeats.length; i++) {
                applicationServices.bookSeatByShowtimeIdAndSeatName(this.$route.params.id, this.selectedSeats[i]);
            }
            
        },
        calculateTotalCost(){
            if(this.showtimes.matinee === true){
                this.totalCosts = (this.childCount * 8) + (this.adultCount * 13) + (this.seniorCount * 10);
                this.order.totalCost = this.totalCosts;
            } else {
                this.totalCosts = (this.childCount * 10) + (this.adultCount * 15) + (this.seniorCount * 12);
                this.order.totalCost = this.totalCosts;
            }
        },
        getTotalCost(){
            this.order.totalCost = this.totalCosts.toFixed(2);
        },
        addCarbonatedBeverage(){
            if(this.carbonatedBeverage === true){
                this.totalCosts = this.totalCosts + .50;
            } else{
                this.totalCosts = this.totalCosts - .50;
            }
        },
         addPopcorn(){
            if(this.popcorn === true){
                this.totalCosts = this.totalCosts + 1.50;
            } else{
                this.totalCosts = this.totalCosts - 1.50;
            }
        },
        addBoxCandy(){
            if(this.boxCandy === true){
                this.totalCosts = this.totalCosts + 2.00;
            } else{
                this.totalCosts = this.totalCosts - 2.00;
            }
        },
        submitOrder() {
            applicationServices.addOrder(this.order);
        },
        selectedSeatsToString(){
            
            this.order.seats = this.selectedSeats.join(', ');
        },
        getChosenDate(){
      let today = new Date();
      let today_weekCode = today.getDay() == 0? 7: today.getDay();
      let chosen_timestamp;
      if(this.showtimes.dayofweek === 'Monday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 1) * 1000*3600*24;
          } if(this.showtimes.dayofweek === 'Tuesday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 2) * 1000*3600*24;
          } if(this.showtimes.dayofweek === 'Wednesday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 3) * 1000*3600*24;
          } if(this.showtimes.dayofweek === 'Thursday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 4) * 1000*3600*24;
          } if(this.showtimes.dayofweek === 'Friday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 5) * 1000*3600*24;
          } if(this.showtimes.dayofweek === 'Satuday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 6) * 1000*3600*24;
          } if(this.showtimes.dayofweek === 'Sunday'){
          chosen_timestamp = today.getTime() - (today_weekCode - 7) * 1000*3600*24;
          }
            let chosenDay = new Date(chosen_timestamp);
            this.order.showtimeDate = (chosenDay.getMonth() + 1) + "/" + chosenDay.getDate() + "/" + chosenDay.getFullYear();
    
         },
    },
    created(){
      applicationServices.getSeatsByShowtimeId(this.$route.params.id).then(response => {
          this.seats = response.data;
      })

      applicationServices.getMovieByShowtimeId(this.$route.params.id).then(response => {
          this.movie = response.data;
      })

      applicationServices.getShowtimeByShowtimeId(this.$route.params.id).then(response => {
          this.showtimes = response.data;
      })
    
      this.interval = setInterval(() => this.checkSeats(), 1);
    },
     computed:{
       
    },
}
</script>

<style>
.orders-button {
  background-color:#AD974F;
  color: #EAEAEA;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.checkout-button{
  background-color:#AD974F;
  color: #EAEAEA;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}


.available-seats{
   color: #AD974F;
}


.tickets-container{
   
    background-color: #231F20;
    color: #AD974F;
    border: 5px double #AD974F;
    
}

.selected-box{
 color: #AD974F;
}


#checkout {
  background-color:#AD974F;
  color: #EAEAEA;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.checkout-box, select, textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

.checkout-box {
    color: #000 !important;
    background-color: #AD974F !important;
}

.box{
 
  width:auto; height:100px;  
  border:solid 5px #AD974F;
  border-color:#AD974F transparent transparent transparent;
  border-radius:   80%/100px 100px 0 0;

  color: #AD974F;


  
}

</style>