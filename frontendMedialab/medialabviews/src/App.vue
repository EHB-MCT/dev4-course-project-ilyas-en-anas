<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
   

    <div class="wrapper">
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
              <RouterLink class="navbar-brand" exact to="/">Navbar</RouterLink>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                  <li class="nav-item">
                    <RouterLink class="nav-link" exact   to="/">Home</RouterLink>
                  </li>

                  <li class="nav-item">
                    <RouterLink class="nav-link" exact  to="/items">Items</RouterLink>
                  </li>

                  <li class="nav-item">
                    <RouterLink class="nav-link" exact  to="/users">Users</RouterLink>
                  </li>

                  <li class="nav-item">
                    <RouterLink class="nav-link" exact  to="/loans">Loans</RouterLink>
                  </li>

                  <li class="nav-item">
                    <RouterLink class="nav-link" exact to="/signup">Signup</RouterLink>
                  </li>

                  <li class="nav-item">
                    <RouterLink class="nav-link" exact to="/login">Login</RouterLink>
                  </li>


                 <!-- <li class="nav-item">
                    <RouterLink class="nav-link" to="/laternog">later</RouterLink>
                  </li>-->

                </ul>
              </div> 
            </div>
          </nav>
    </div>

  </header>
  <RouterView />
</template>

<style scoped>

</style>
