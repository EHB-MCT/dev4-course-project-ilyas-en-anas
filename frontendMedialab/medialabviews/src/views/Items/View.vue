<template>
  <main> 
    <h1>This is an items page</h1>
  </main>

  <router-link to="/itemadd" class="btn btn-primary">+ Add Item</router-link>

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
      <tr v-for="(item, index) in items" :key="item.id">
        <th scope="row">{{ index + 1 }}</th>
        <td>{{ item.name }}</td>
        <td>{{ item.description }}</td>
        <td>
          <button @click="$router.push({ name: 'itemdetail', params: { id: item.id } })" style="margin-right: 10px;" type="button" class="btn btn-info">Info</button>
          <button @click="$router.push({ name: 'itemupdate', params: { id: item.id } })" style="margin-right: 10px;" type="button" class="btn btn-warning">Edit</button>
          <button @click="deleteItem(item.id)" style="margin-right: 10px;" type="button" class="btn btn-danger">Delete</button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      items: [],
      actionSuccessful: false
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
        });
    }
  },
  created() {
    this.fetchItems()
  }
}
</script>
