<template>
  <div id="loginn" class="text-center">
    
    <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5 pb-6">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-3 mt-md-2 pb-3">

              <img src="https://i.imgur.com/dV74N8o.png" title="source: imgur.com" />
              <p class="text-white-50 mb-5">Please enter your login and password!</p>
              <p class="alert" v-if="invalidCredentials">Invalid username and password!</p>

              <div class="form-outline form-white mb-4">
                <input type="text" id="typeTextX" class="form-control form-control-lg" v-model="user.username" required autofocus />
                <label class="form-label" for="typeTextX">Username</label>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="typePasswordX" class="form-control form-control-lg" v-model="user.password" required />
                <label class="form-label" for="typePasswordX">Password</label>
              </div>

              <button class="btn btn-outline-light btn-lg px-5" type="submit" v-on:click="login()">Login</button>

            </div>

            <div>
              <p class="mb-0">Don't have an account? <router-link :to="{ name: 'register' }"> <a href="#!" class="text-white-50 fw-bold">Sign Up</a></router-link></p>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.alert{
color: #d8d518;
}
#login-title{
  max-width: 60%;
  margin: auto;
  color: #8E793E;
}

/*.alert-success{
  color: #EAEAEA;
}

#login{
  padding-bottom: 20px;
  color: #EAEAEA;
  max-width: 40%;
  margin: auto;
  background-size: auto;
  margin-top: 1%;
  
  
  
}


#login-title{
  background-color: #231F20;
  max-width: 60%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  color: #8E793E;
  margin-bottom: 20px;
}

#username-div{
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  
}
#password-div{
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#username{
margin-left: 1%;
border-radius: 5px;
}

#password{
margin-left: 2%;
border-radius: 5px;
}

#register{
 background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px; 
}
#sign-in{
  margin-top: 5px;
  margin-bottom: 5px;
}

#register a{
  color: #EAEAEA;
}

.form-control{
  background-color: #EAEAEA;
}*/


</style>