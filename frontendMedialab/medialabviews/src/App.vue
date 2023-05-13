<script setup>
import { ref, onMounted } from 'vue';
import { RouterLink, RouterView, useRoute } from 'vue-router';

let loggedInUser = ref(null);
const route = useRoute();

onMounted(() => {
  loggedInUser.value = JSON.parse(localStorage.getItem('loggedInUser'));
  if (loggedInUser.value) {
    console.log('Ingelogde gebruiker:', loggedInUser.value);
  }
});

const logout = () => {
  loggedInUser.value = null;
  localStorage.removeItem('loggedInUser');
  console.log('Gebruiker is uitgelogd');
  window.location.href = "/login";
};
</script>

<template>
  <header v-if="$route.path !== '/login'">
    <div class="wrapper">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <RouterLink class="navbar-brand" exact to="/home">EHB Medialab</RouterLink>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <RouterLink class="nav-link" exact to="/home">Home</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" exact to="/items">Items</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" exact to="/users">Users</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" exact to="/loans">Loans</RouterLink>
              </li>

              <li class="nav-item">
                <button class="nav-link btn btn-danger" @click="logout">Logout</button>
              </li>
            </ul>
          </div> 
        </div>
      </nav>
    </div>
  </header>
  <RouterView />
</template>
