<template>
  <div class="showtimes-container">
    

    
    <div class="row d-flex justify-content-center">
      <div class="col d-flex justify-content-end">
        <img class="showtime-movie-poster" v-bind:src="movie.poster" />
      </div>
      <div class="col flex-column d-flex justify-content-start">
        <iframe
          class="video-trailer"
          width="603"
          height="339.19"
          v-bind:src="'https://www.youtube.com/embed/' + this.movie.trailerId"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
        <br />
        <h1 class="trailer-title">{{ this.movie.title }}</h1>
        <p class="movie-release"><Strong><u>Release Date</u></Strong> <br />{{this.movie.releaseDate}}</p>
        <p class="movie-overview"><u><Strong>Overview</Strong></u><br />{{ this.movie.overview }}</p>
      </div>
    </div>

    <div class="calendar">
      <br />
      <h4 class="excample-text">
        {{ this.choosedDay2.month }}/{{ this.choosedDay2.date }}/{{
          this.choosedDay2.year
        }}
      </h4>
      <vue-horizontal-calendar
        lang="en"
        style="width: 410px; margin: 0 auto"
        swipeSpace="7"
        :choosedDate="getThisMondayDate"
        :showBorderTop="false"
        :resizeable="false"
        v-on:change="dateChange2"
        todayItemColor="#99c8f5f6"
        choosedItemColor="#AD974F"
      ></vue-horizontal-calendar>
    </div>

    <div class="times-container time-by-day">
      <div class="times" v-if="!isHidden">
        <showtime-card
          class="start-time"
          v-for="showtime in showtimes"
          v-bind:key="showtime.showtimeId"
          v-bind:showtime="showtime"
        />
      </div>
    </div>
  </div>
</template>

<script>
import applicationServices from "@/services/ApplicationServices.js";
import ShowtimeCard from "./ShowtimeCard.vue";
import VueHorizontalCalendar from "vue-horizontal-calendar";

export default {
  components: {
    ShowtimeCard,
    VueHorizontalCalendar,
  },
  name: "showtimes",
  data() {
    return {
      movie: [],
      showtimes: [],
      isHidden: true,
      currentFirstDay: {
        dateFormat: "",
        year: "",
        month: "",
        date: "",
        day: "",
        timestamp: "",
      },
      choosedDay2: {
        dateFormat: "",
        year: "",
        month: "",
        date: "",
        day: "",
        timestamp: "",
      },
    };
  },
  methods: {
    getSelectedShowtimes(day) {
      return applicationServices
        .getShowtimesByMovieIdAndDayOfWeek(this.$route.params.id, day)
        .then((response) => {
          this.showtimes = response.data;
        });
    },
    firstDayChange(day) {
      this.currentFirstDay = day;
    },
    dateChange2(day) {
        this.choosedDay2 = day;
        let dayOfWeek;

        switch (day.day) {
            case 'Mo':
                dayOfWeek = 'Monday';
                break;
            case 'Tu':
                dayOfWeek = 'Tuesday';
                break;
            case 'We':
                dayOfWeek = 'Wednesday';
                break;
            case 'Th':
                dayOfWeek = 'Thursday';
                break;
            case 'Fr':
                dayOfWeek = 'Friday';
                break;
            case 'Sa':
                dayOfWeek = 'Saturday';
                break;
            case 'Su':
                dayOfWeek = 'Sunday';
                break;
        }

        return applicationServices
            .getShowtimesByMovieIdAndDayOfWeek(this.$route.params.id, dayOfWeek)
            .then((response) => {
                this.showtimes = response.data;
                this.isHidden = false;
            });
    },
  },
  computed: {
    getThisMondayDate() {
      let today = new Date();
      let today_weekCode = today.getDay() == 0 ? 7 : today.getDay();
      let monday_timestamp =
        today.getTime() - (today_weekCode - 1) * 1000 * 3600 * 24;
      let monday = new Date(monday_timestamp);
      return (
        monday.getFullYear() +
        "/" +
        (monday.getMonth() + 1) +
        "/" +
        monday.getDate()
      );
    },
  },
  created() {
    //applicationServices.getShowtimesByMovieId(this.$route.params.id).then(response =>{
    //    this.showtimes = response.data;
    //});

    applicationServices
      .getChosenMovie(this.$route.params.id)
      .then((response) => {
        this.movie = response.data;
      });

    //applicationServices.getShowtimesByMovieIdAndDayOfWeek(this.$route.params.id, "Monday").then(response =>{
    //    this.showtimes = response.data;

    //});
    this.getSelectedShowtimes();
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Limelight&display=swap%27");
@import url("https://fonts.googleapis.com/css2?family=Open+Sans&display=swap");

.poster-trailer {
 
  font-family: "Limelight", cursive;
}

.trailer-title {
 text-align: start;
 color: #ad974f;
}

.movie-release {
 text-align: start;
 color: #ad974f;
  
}

.movie-overview {
  color: #ad974f;
  width: 603px;
  text-align: left;
  line-height: 1.5;
  font-family: "Open Sans", "Regular";
}

.chosen-date {
  color: #ad974f;
  padding-top: 2%;
  text-align: center;
  line-height: 1.5;
  font-family: "Open Sans", "Regular";
}

.showtimes-container {
  background-color: #231f20;
}

.times {
  display: flex;
  width: 415px;
  background-color: #ad974f;
  justify-content: space-evenly;
  font-family: "Open Sans", "Regular";
  border: 5px double #231f20;
  color: #231f20;
  font-size: 10px;
  margin-bottom: 1%;
}

.showtime-movie-poster {
  width: 30rem;
  height: auto;
  
}
h1.showtime-movie-title {
  font-size: 40px;
  padding-top: 1%;
  font-family: "Limelight", cursive;
  border: 5px double #ad974f;
  max-width: 40%;
  margin: auto;
  margin-bottom: 5%;
  padding-bottom: 1%;
}

.times-container {
  margin: auto;
  display: flex;
  justify-content: center;
}
.day-buttons:hover {
  background-color: #ad974f;
  border: 5px double #231f20;
}
.day-buttons {
  border: 5px double #ad974f;
  background-color: #231f20;
  color: #eaeaea;
  font-family: "Limelight", cursive;
  font-size: 100%;
}
.times-by-day {
  max-width: 50%;
  margin: auto;
}

.buttons-container-time-by-day {
  padding-top: 2%;
}
</style>