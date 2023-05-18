<template>
  <div class="container">
    <h1 class="text-center my-4">My Loans</h1>
    <div class="card mb-3" v-for="loan in loans" :key="loan.id">
      <div class="card-header">
        Loan for Item: {{ loan.item.name }}
      </div>
      <div class="card-body">
        <h5 class="card-title">Item Details</h5>
        <p class="card-text">Name: {{ loan.item.name }}</p>
        <p class="card-text">Description: {{ loan.item.description }}</p>

        <h5 class="card-title mt-3">Loan Details</h5>
        <p class="card-text">Start Date: {{ loan.startDate }}</p>
        <p class="card-text">End Date: {{ loan.endDate }}</p>
        <p class="card-text">Note: {{ loan.notes }}</p>

        <div class="mt-3">
          <h5 class="card-title">Add Note</h5>
          <input class="form-control mb-2" v-model="newNote[loan.id]" type="text">
          <button class="btn btn-primary" @click="addNote(loan.id)">Submit</button>
        </div>
      </div>
    </div>
  </div> 
</template>


<script>
import axios from 'axios'

export default {
  data() {
    return {
      loggedInUser: null,
      loans: [],
      newNote: {}
    }
  },
  mounted() {
    if (!localStorage.getItem('refreshed')) {
      localStorage.setItem('refreshed', 'true');
      location.reload();
    } else {
      localStorage.removeItem('refreshed'); 
    }
    
    this.loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));

    console.log(this.loggedInUser);
    if (this.loggedInUser) {
      axios.get(`http://localhost:3333/api/loans/user/${this.loggedInUser.userId}`)
        .then(response => {
          this.loans = response.data
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    }
  },
  methods: {
    addNote(loanId) {
  if (!this.newNote[loanId]) {
    alert("Please enter a note.");
    return;
  }

  axios.patch(`http://localhost:3333/api/loans/${loanId}/notes`, this.newNote[loanId] , { headers: { 'Content-Type': 'text/plain' }})
    .then(response => {
      this.newNote[loanId] = '';
      const loanIndex = this.loans.findIndex(loan => loan.id === loanId);
      if (loanIndex !== -1) {
        this.loans[loanIndex] = response.data;
      }
    })
    .catch(error => {
      console.error('There was an error!', error);
    });
}
  }
};
</script>

