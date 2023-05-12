<template>
  <main>
    <h1>Update User</h1>
    <form @submit.prevent="updateUser">
      <div class="form-group">
        <label for="name">User Name</label>
        <input id="name" v-model="currentUser.name" type="text" class="form-control">
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input id="email" v-model="currentUser.email" type="text" class="form-control">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input id="password" v-model="currentUser.password" type="password" class="form-control">
      </div>
      <div class="form-group">
        <label for="role">Role</label>
        <select id="role" v-model="currentUser.roleId" class="form-control">
          <option v-for="role in roles" :key="role.id" :value="role.id">
            {{ role.name }}
          </option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Update User</button>
    </form>
  </main>
</template>

<script>
import axios from 'axios'

export default {
data() {
  return {
    currentUser: {
      name: '',
      email: '',
      password: '',
      roleId: null
    },
    roles: []
  }
},
methods: {
  fetchUser() {
    axios.get(`http://localhost:3333/api/users/${this.$route.params.id}`)
      .then(response => {
        this.currentUser = response.data;
        this.currentUser.roleId = response.data.role.id; // Set roleId from the role object
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  },
  fetchRoles() {
    axios.get('http://localhost:3333/api/roles')
      .then(response => {
        this.roles = response.data;
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  },
  updateUser() {
    const userDto = {
      name: this.currentUser.name,
      email: this.currentUser.email,
      password: this.currentUser.password,
      roleId: this.currentUser.roleId
    };
    axios.put(`http://localhost:3333/api/users/${this.$route.params.id}`, userDto)
      .then(() => {
        this.$router.push('/users')
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  }
},
created() {
  this.fetchUser();
  this.fetchRoles();
}
}
</script>
