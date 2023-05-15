<template>
  <main class="container mt-5">
    <h1 class="mb-4">Add a new item</h1>
    <form @submit.prevent="addItem">
      <div class="form-group">
        <label for="name">Item Name</label>
        <input id="name" v-model="newItem.name" type="text" class="form-control" required>
      </div>
      <div class="form-group mt-4">
        <label for="description">Item Description</label>
        <textarea id="description" v-model="newItem.description" class="form-control" rows="3" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary mt-4">Add Item</button>
    </form>
  </main> 
</template> 


    
  <script>
  import axios from 'axios'
  
  export default {
    data() {
      return {
        newItem: {
          name: '',
          description: ''
        }
      }
    },
    methods: {
      addItem() {
        axios.post('http://localhost:3333/api/items', this.newItem)
          .then(() => {
            this.$router.push('/items')
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
      }
    }
  }
  </script>
  