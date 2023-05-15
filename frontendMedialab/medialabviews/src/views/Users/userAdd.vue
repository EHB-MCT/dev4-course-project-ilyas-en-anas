<template>
  <main class="container mt-5">
    <h1 class="mb-4">Add a new user</h1>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="inputName">Name</label>
        <input id="inputName" v-model="name" type="text" class="form-control" required>
      </div>
      <div class="form-group mt-4">
        <label for="inputEmail">Email address</label>
        <input id="inputEmail" v-model="email" type="email" class="form-control" required>
      </div>
      <div class="form-group mt-4">
        <label for="inputPassword">Password</label>
        <input id="inputPassword" v-model="password" type="password" class="form-control" required>
      </div>
      <div class="form-group mt-4">
        <label for="inputRoleId">Select Role</label>
        <select id="inputRoleId" v-model="roleId" class="form-control" required>
          <option value="1">admin</option>
          <option value="2">user</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary mt-4">Add User</button>
    </form>
  </main> 
</template>


<script>
import axios from "axios";

export default {
name: "AddUserView",
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
      await axios.post("http://localhost:3333/api/users/add", userData);
      this.$router.push('/users');
    } catch (error) {
      console.error("Error creating user:", error.response.data);
    }
  },
},
};
</script>
