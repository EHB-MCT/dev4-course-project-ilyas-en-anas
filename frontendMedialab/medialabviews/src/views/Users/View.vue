<template>
  <main class="container">
    <h1 class="text-center my-4">This is a users page</h1>
    <div class="input-group mb-3">
      <router-link to="/useradd" class="btn btn-primary mr-2">+ Add User</router-link>
      <input type="text" class="form-control" v-model="search" placeholder="Search users by name">
    </div>

    <div class="alert alert-success" role="alert" v-if="actionSuccessful">
      Action done with success!
    </div> 

    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(user, index) in filteredUsers" :key="user.id">
          <th scope="row">{{ index + 1 }}</th>
          <td>{{ user.name }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.role.name }}</td>
          <td>
            <!--<button @click="$router.push({ name: 'userupdate', params: { id: user.id } })" class="btn btn-warning mr-2">Edit</button>-->
            <button @click="deleteUser(user.id)" class="btn btn-danger">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>



<script>
import axios from 'axios'

export default {
  data() {
    return {
      users: [],
      search: '', 
      actionSuccessful: false
    }
  },
  computed: {
    filteredUsers() { 
      return this.users.filter(user => user.name.toLowerCase().includes(this.search.toLowerCase()))
    }
  }, 
  methods: {
    fetchUsers() {
      axios.get('http://localhost:3333/api/users/allusers')
        .then(response => {
          this.users = response.data
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    },
    deleteUser(id) {
      axios.delete(`http://localhost:3333/api/users/${id}`)
        .then(response => {
          this.users = this.users.filter(user => user.id !== id)
          this.actionSuccessful = true
        })
        .catch(error => {
          console.error('There was an error!', error);
          this.actionSuccessful = false
          alert("A loan exists with this User!")
        });
    }
  },
  created() {
    this.fetchUsers()
  }
}
</script>
