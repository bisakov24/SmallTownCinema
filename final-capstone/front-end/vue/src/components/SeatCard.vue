<template>
    <div class="seat-card">
        <button class ="seat-name" >{{this.seat.name}}</button>
    </div>
</template>

<script>
export default {
    name: 'seat-card',
    props: ['seat']
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap%27');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.seat-card{
    
    display: inline-block;
   
    background-color: #231F20;
    
  

  
   
    
    
}

button.seat-name{
    font-family: 'Open Sans', 'Regular';
    padding: 15px 32px;
    background-color: #231F20;
    border: double 5px #AD974F;
    color:#EAEAEA;
}

.seat-name:hover{
    background-color: #AD974F;
    
}



</style>