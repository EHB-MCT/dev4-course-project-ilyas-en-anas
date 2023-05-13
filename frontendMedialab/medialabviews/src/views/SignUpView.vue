<template>
    <div>
      <h1>Signup Page</h1>
  
      <form @submit.prevent="submitForm">
        <div class="mb-3">
          <label for="inputName" class="form-label">Name</label>
          <input
            type="text"
            class="form-control"
            id="inputName"
            v-model="name" 
          />
        </div>
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
        <div class="mb-3">
          <label for="inputRoleId" class="form-label">Role ID</label>
          <input
            type="number"
            class="form-control"
            id="inputRoleId"
            v-model="roleId"
          />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
      <p>Already have an account? <router-link to="/login">Log in</router-link></p>
    </div>
  </template>
  
  <script>
import axios from "axios";


  export default {
    name: "SignupView",
    data() {
      return {
        name: "",
        email: "",
        password: "",
        roleId: 1,
      };
    },
    methods: {
      async submitForm() {
        const userData = {
          name: this.name,
          email: this.email,
          password: this.password,
          roleId: this.roleId,
        };
  
        try {
        const response = await axios.post("http://localhost:3333/api/users/register", userData);
        console.log("User created successfully:", response.data);
        alert("user created")
        this.$router.push('/home');
      } catch (error) {
        console.error("Error creating user:", error.response.data);
      }
      },
    },
  };
  </script>
  