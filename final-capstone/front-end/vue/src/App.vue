<template>
  <div id="app">
<nav>
<a href="/"><img style="float: right;" class="header-logo" src="https://i.imgur.com/dV74N8o.png" title="source: imgur.com" /></a>


  <input type="checkbox" class="openSidebarMenu" id="openSidebarMenu">
  <label for="openSidebarMenu" class="sidebarIconToggle">
    <div class="spinner diagonal part-1"></div>
    <div class="spinner horizontal"></div>
    <div class="spinner diagonal part-2"></div>
  </label>
 
  <div id="sidebarMenu">
    <ul class="sidebarMenuInner">
      <li><img class="nav-logo" src="https://i.imgur.com/dV74N8o.png" title="source: imgur.com" /></li>
      <li><router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link></li>
      <li><router-link class="nav-link" v-bind:to="{ name: 'myOrders' }" v-if="$store.state.token != ''">My Orders</router-link></li>
      <li><router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
      <li><router-link class="nav-link" v-bind:to="{ name: 'adminSettings' }" v-if="this.$store.state.user.username == 'admin'">Admin Settings</router-link></li>

    </ul>
  </div>
</nav>
 <div class="container my-2">



  </div>
    <router-view />
  </div>
</template>


<style>
html{
  background-color: #231F20; 

}
/*#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #AD974F;
  background-color: #231f20;
  

}*/
#app{
  background-color: #231f20;
}

.nav-logo{
  width: 100%;
}

img.header-logo{
 width:10%;
}


@import url('https://fonts.googleapis.com/css?family=Varela+Round');


#sidebarMenu {
    height: 100%;
    position: fixed;
    left: 0;
    width: 250px;
    margin-top: 60px;
    transform: translateX(-250px);
    transition: transform 250ms ease-in-out;
    background: linear-gradient(180deg, #231f20 0%, #3F5EFB 100%);
}
.sidebarMenuInner{
    margin:0;
    padding:0;
    border-top: 1px solid rgba(255, 255, 255, 0.10);
}
.sidebarMenuInner li{
    list-style: none;
    color: #fff;
    text-transform: uppercase;
    font-weight: bold;
    padding: 20px;
    cursor: pointer;
    border-bottom: 1px solid rgba(255, 255, 255, 0.10);
}
.sidebarMenuInner li span{
    display: block;
    font-size: 14px;
    color: rgba(255, 255, 255, 0.50);
}
.sidebarMenuInner li a{
    color: #fff;
    text-transform: uppercase;
    font-weight: bold;
    cursor: pointer;
    text-decoration: none;
}
input[type="checkbox"]:checked ~ #sidebarMenu {
    transform: translateX(0);
}

input[type=checkbox] {
    transition: all 0.3s;
    box-sizing: border-box;
}

.openSidebarMenu{
display: none;
}

.sidebarIconToggle {
    transition: all 0.3s;
    box-sizing: border-box;
    cursor: pointer;
    position: absolute;
    z-index: 99;
    height: 100%;
    width: 100%;
    top: 22px;
    left: 15px;
    height: 22px;
    width: 22px;
}
.spinner {
    transition: all 0.3s;
    box-sizing: border-box;
    position: absolute;
    height: 3px;
    width: 100%;
    background-color: #fff;
}
.horizontal {
    transition: all 0.3s;
    box-sizing: border-box;
    position: relative;
    float: left;
    margin-top: 3px;
}
.diagonal.part-1 {
    position: relative;
    transition: all 0.3s;
    box-sizing: border-box;
    float: left;
}
.diagonal.part-2 {
    transition: all 0.3s;
    box-sizing: border-box;
    position: relative;
    float: left;
    margin-top: 3px;
}
input[type=checkbox]:checked ~ .sidebarIconToggle > .horizontal {
    transition: all 0.3s;
    box-sizing: border-box;
    opacity: 0;
}
input[type=checkbox]:checked ~ .sidebarIconToggle > .diagonal.part-1 {
    transition: all 0.3s;
    box-sizing: border-box;
    transform: rotate(135deg);
    margin-top: 8px;
}
input[type=checkbox]:checked ~ .sidebarIconToggle > .diagonal.part-2 {
    transition: all 0.3s;
    box-sizing: border-box;
    transform: rotate(-135deg);
    margin-top: -9px;
}



</style>
