<template>
  <div id="register-page" class="text-centerr">
    
    <section class="vh-100 bg-image">
  <div class="container py-5 h-100">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6 pb-6">
          <div class="card bg-dark text-white" style="border-radius: 15px;">
            <div class="card-body p-4">
              <h2 class="text-uppercase text-center mb-3">Create an account</h2>

              <form>

                 <div class="form-outline mb-1">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" v-model="user.username" />
                  <label class="form-label" for="form3Example1cg">Username</label>
                </div>

                <div class="form-outline mb-1">
                  <input type="text" id="form3Example1cg" class="form-control form-control-lg" v-model="user.fullName" />
                  <label class="form-label" for="form3Example1cg">Name</label>
                </div>

                <div class="form-outline mb-1">
                  <input type="email" id="form3Example3cg" class="form-control form-control-lg" v-model="user.email" />
                  <label class="form-label" for="form3Example3cg">Email</label>
                </div>

                <div class="form-outline mb-1">
                  <input type="password" id="form3Example4cg" class="form-control form-control-lg" v-model="user.password" />
                  <label class="form-label" for="form3Example4cg">Password</label>
                </div>

                <div class="form-outline mb-1">
                  <input type="password" id="form3Example4cdg" class="form-control form-control-lg" v-model="user.confirmPassword" />
                  <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" v-on:click.prevent="register()">Register</button>
                </div>

                <p class="text-center text-muted mt-2 mb-0">Have already an account? <router-link v-bind:to="{ name: 'home' }"><a href="#!" class="text-white-50 fw-bold"><u>Login here</u></a></router-link></p>

              </form>

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
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        fullName: '',
        email: '',
      },
      isHidden: false,
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
      isDisabled(){
            if(this.selectedCount === 0) {
                return true;
            } else {
                return false;
            }
        },
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'The username is already taken';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    reloadPage(){
        window.location.reload()
        },
  },
};
</script>

<style>

/*#register-title{
  background-color: #231F20;
  max-width: 60%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  color: #8E793E;
  margin-bottom: 20px;
}

.form-control{
  float: right;
}


#register-page{
  background-color: #8E793E;
  background-image: url('../assets/fancy-image.jpg');
  padding-bottom: 20px;
  color: #EAEAEA;
  max-width: 40%;
  margin: auto;
  background-size: 100%;
  margin-top: 1%;
}

#fullName-div{
  text-align: start;
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#email-div{
  text-align: start;
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#username-div{
  text-align: start;
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
  
}
#password-div{
  text-align: start;
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#username{
  
  border-radius: 5px;
}

#fullName{
  
  border-radius: 5px;
}

#email{
  
  border-radius: 5px;
}

#password{
  
  border-radius: 5px;
}

#confirmPassword{
  
  border-radius: 5px;
}

#confirm-password{
  text-align: start;
  background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px;
}

#create-account{
  margin-top: 5px;
  margin-bottom: 5px;
}

#have-account{
 background-color: #231F20;
  max-width: 50%;
  border: 2px solid #AD974F;
  margin: auto;
  border-radius: 5px; 
}

#have-account a{
  color: #EAEAEA;
}*/

.pb-6 {
  margin-bottom: 18em !important;
}







.gradient-custom-4 {
  /* fallback for old browsers */
  background: #84fab0;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1))
}
</style>
