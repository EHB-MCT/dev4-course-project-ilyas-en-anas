<template>
  <div>
    <h1>All the Details of the loan</h1>
    <h2>User Details</h2>
    <p>User ID: {{ loan.user.id }}</p>
    <p>User Name: {{ loan.user.name }}</p>
    <p>User Email: {{ loan.user.email }}</p>
    
    <h2>Item Details</h2>
    <p>Item ID: {{ loan.item.id }}</p>
    <p>Item Name: {{ loan.item.name }}</p>
    <p>Item Description: {{ loan.item.description }}</p>

    <h2>Loan Details</h2>
    <p>Loan ID: {{ loan.id }}</p>
    <p>Loan Start Date: {{ loan.startDate }}</p>
    <p>Loan End Date: {{ loan.endDate }}</p>
    <p>Loan Notes: {{ loan.notes }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      loan: {}
    }
  },
  created() {
    this.fetchLoanDetails()
  },
  watch: {
    '$route.params.id': {
      immediate: true,
      handler(newVal) {
        this.fetchLoanDetails(newVal);
      },
    },
  },
  methods: {
    fetchLoanDetails(id) {
      axios.get(`http://localhost:3333/api/loans/${id || this.$route.params.id}`)
        .then(response => {
          this.loan = response.data
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    }
  }
}
</script>
