<template>
    <main>
      <h1>Update an item</h1>
      <form @submit.prevent="updateItem">
        <div class="form-group">
          <label for="name">Item Name</label>
          <input id="name" v-model="currentItem.name" type="text" class="form-control">
        </div>
        <div class="form-group">
          <label for="description">Item Description</label>
          <input id="description" v-model="currentItem.description" type="text" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Update Item</button>
      </form>
    </main>
  </template>
  
  <script>
  import axios from 'axios'
  
  export default {
    data() {
      return {
        currentItem: {
          name: '',
          description: ''
        }
      }
    },
    methods: {
      fetchItem() {
        axios.get(`http://localhost:3333/api/items/${this.$route.params.id}`)
          .then(response => {
            this.currentItem = response.data;
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
      },
      updateItem() {
        axios.put(`http://localhost:3333/api/items/${this.$route.params.id}`, this.currentItem)
          .then(() => {
            this.$router.push('/items')
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
      }
    },
    created() {
      this.fetchItem()
    }
  }
  </script>
  