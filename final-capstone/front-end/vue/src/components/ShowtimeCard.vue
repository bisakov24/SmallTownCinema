<template>
    <div class="showtime-card">
        <router-link v-bind:to="{ path: '/seats/' + this.showtime.showtimeId }">
        <h1 class ="start-time">{{this.showtime.startTime}}</h1>
        </router-link>
    </div>
</template>
<script>
export default {
    name: 'showtime-card',
    props: ['showtime']
}
</script>
<style>
.showtime-card{

max-width:40%;
margin: auto;
}

</style>