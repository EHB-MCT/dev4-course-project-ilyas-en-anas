<template>
  <div>
    <h1>Login Page</h1>

    <form @submit.prevent="submitForm">
      <div class="mb-3">
        <label for="inputEmail" class="form-label">Email address</label>
        <input
          type="email"
          class="form-control"
          id="inputEmail" 
          v-model="email"
        />
      </div>
      <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input
          type="password"
          class="form-control"
          id="inputPassword"
          v-model="password"
        />
      </div>
      <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <!--<p>Don't have an account? <router-link to="/">Sign Up</router-link></p>-->
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginView",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    async submitForm() {
      const loginData = {
        email: this.email,
        password: this.password,
      };

      try {
        const response = await axios.post(
          "http://localhost:3333/api/users/login",
          loginData
        );
        console.log("User status:", response.data);
        
        
        if (response.data === "User not found" || response.data === "Incorrect password") {
          alert(response.data); 
        } else {
          localStorage.setItem('loggedInUser', JSON.stringify(response.data));
          console.log('Ingelogde gebruiker:', response.data);
          alert("Login successful"); 
          this.$router.push('/home'); 
        }
      } catch (error) {
        console.error("Error logging in:", error.response.data);
      }
    },
  },
};
</script>
 