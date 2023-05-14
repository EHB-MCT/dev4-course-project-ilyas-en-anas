<template>
  <div>
    <h1>My Loans</h1>
    <div v-for="loan in loans" :key="loan.id">
      <h2>Item Details</h2>
      <p>Item Name: {{ loan.item.name }}</p>
      <p>Item Description: {{ loan.item.description }}</p>

      <h2>Loan Details</h2>
      <p>Loan Start Date: {{ loan.startDate }}</p>
      <p>Loan End Date: {{ loan.endDate }}</p>
      <p>Loan Note: {{ loan.notes }}</p>

      <h2>Add Note</h2>
      <input v-model="newNote[loan.id]" type="text">
      <button @click="addNote(loan.id)">Submit</button>
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

