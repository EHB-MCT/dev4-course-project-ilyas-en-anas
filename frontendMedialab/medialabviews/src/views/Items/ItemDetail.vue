<template>
  <div class="container mt-5">
    <h1 class="text-center my-4">Item Details</h1>
    <div class="card mb-3">
      <div class="card-header">
        Item ID: {{ item.id }}
      </div>
      <div class="card-body">
        <h5 class="card-title">Item Name</h5>
        <p class="card-text">{{ item.name }}</p>
        <h5 class="card-title mt-3">Item Description</h5>
        <p class="card-text">{{ item.description }}</p>
      </div>
    </div>
  </div>
</template>

  
  <script>
  import axios from 'axios'
  
  export default {
    props: ['id'], // 
    data() {
      return {
        item: null
      }
    },
    created() {
      this.fetchItemDetails()
    },
    methods: {
      fetchItemDetails() {
        const id = this.id // id uit de props
        axios.get(`http://localhost:3333/api/items/${id}`)
          .then(response => {
            this.item = response.data
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
      }
    }
  }
  </script>
  