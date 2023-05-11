<template>
    <div>
      <h1>Item Details</h1>
      <p>Item ID: {{ item.id }}</p>
      <p>Item Name: {{ item.name }}</p>
      <p>Item Description: {{ item.description }}</p>
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
  