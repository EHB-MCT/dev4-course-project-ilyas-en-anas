<template>
  <main class="container mt-5">
    <h1 class="text-center my-4">Loan Details</h1>

    <div class="card mb-3">
      <div class="card-header">
        Loan ID: {{ loan.id }}
      </div>
      <div class="card-body">
        <h5 class="card-title">Start Date</h5>
        <p class="card-text">{{ loan.startDate }}</p>
        <h5 class="card-title mt-3">End Date</h5>
        <p class="card-text">{{ loan.endDate }}</p>
        <h5 class="card-title mt-3">Note</h5>
        <p class="card-text">{{ loan.notes }}</p>

        <hr>

        <h5 class="card-title mt-3">User Details</h5>
        <p class="card-text">User ID: {{ loan.user.id }}</p>
        <p class="card-text">User Name: {{ loan.user.name }}</p>
        <p class="card-text">User Email: {{ loan.user.email }}</p>

        <hr>

        <h5 class="card-title mt-3">Item Details</h5>
        <p class="card-text">Item ID: {{ loan.item.id }}</p>
        <p class="card-text">Item Name: {{ loan.item.name }}</p>
        <p class="card-text">Item Description: {{ loan.item.description }}</p>
      </div>
    </div>
  </main>
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
