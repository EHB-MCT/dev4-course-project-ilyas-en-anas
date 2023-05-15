<template>
  <main class="container">
    <h1 class="text-center my-4">This is an items page</h1>
    <div class="input-group mb-3">
      <router-link to="/itemadd" class="btn btn-primary mr-2">+ Add Item</router-link>
      <input type="text" class="form-control" v-model="search" placeholder="Search items by name">
    </div>

    <div class="alert alert-success" role="alert" v-if="actionSuccessful">
      Action done with success!
    </div> 
 
    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Description</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in filteredItems" :key="item.id">
          <th scope="row">{{ index + 1 }}</th>
          <td>{{ item.name }}</td>
          <td>{{ item.description }}</td>
          <td>
            <button style="margin-right: 10px;" @click="$router.push({ name: 'itemdetail', params: { id: item.id } })" class="btn btn-info mr-2">Info</button>
            <button style="margin-right: 10px;" @click="$router.push({ name: 'itemupdate', params: { id: item.id } })" class="btn btn-warning mr-2">Edit</button>
            <button @click="deleteItem(item.id)" class="btn btn-danger">Delete</button>
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
      items: [],
      search: '', 
      actionSuccessful: false
    }
  },
  computed: {
    filteredItems() { 
      return this.items.filter(item => item.name.toLowerCase().includes(this.search.toLowerCase()))
    }
  },
  methods: {
    fetchItems() {
      axios.get('http://localhost:3333/api/items')
        .then(response => {
          this.items = response.data
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    },
    deleteItem(id) {
      axios.delete(`http://localhost:3333/api/items/${id}`)
        .then(response => {
          this.items = this.items.filter(item => item.id !== id)
          this.actionSuccessful = true
        })
        .catch(error => {
          console.error('There was an error!', error);
          this.actionSuccessful = false
          alert("A loan exists with this Item!")
        });
    }
  },
  created() {
    this.fetchItems()
  }
}
</script>
