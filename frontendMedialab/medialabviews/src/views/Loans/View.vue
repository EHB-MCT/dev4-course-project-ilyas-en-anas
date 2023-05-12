<template>
  <main> 
    <h1>This is a loans page</h1>
    <div class="input-group mb-3">
      <router-link to="/loanadd" class="btn btn-primary">+ Add Loan</router-link>
      <input type="text" class="form-control ml-2" v-model="search" placeholder="Search loans by user name or item name">
    </div>

    <div class="alert alert-success" role="alert" v-if="actionSuccessful">
      Action done with success!
    </div>

    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">User</th>
          <th scope="col">Item</th>
          <th scope="col">Start Date</th>
          <th scope="col">End Date</th>
          <th scope="col">Notes</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(loan, index) in filteredLoans" :key="loan.id">
          <th scope="row">{{ index + 1 }}</th>
          <td>{{ loan.user.name }}</td>
          <td>{{ loan.item.name }}</td>
          <td>{{ loan.startDate }}</td>
          <td>{{ loan.endDate }}</td>
          <td>{{ loan.notes }}</td>
          <td>
            <button @click="$router.push({ name: 'loandetail', params: { id: loan.id } })" style="margin-right: 10px;" type="button" class="btn btn-info">Info</button>
            <button @click="$router.push({ name: 'loanupdate', params: { id: loan.id } })" style="margin-right: 10px;" type="button" class="btn btn-warning">Edit</button>
            <button @click="deleteLoan(loan.id)" style="margin-right: 10px;" type="button" class="btn btn-danger">Delete</button>
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
      loans: [],
      search: '', 
      actionSuccessful: false
    }
  },
  computed: {
    filteredLoans() { 
      return this.loans.filter(loan => 
        loan.user.name.toLowerCase().includes(this.search.toLowerCase()) ||
        loan.item.name.toLowerCase().includes(this.search.toLowerCase())
      )
    }
  },
  methods: {
    fetchLoans() {
      axios.get('http://localhost:3333/api/loans')
        .then(response => {
          this.loans = response.data
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    },
    deleteLoan(id) {
      axios.delete(`http://localhost:3333/api/loans/${id}`)
        .then(response => {
          this.loans = this.loans.filter(loan => loan.id !== id)
          this.actionSuccessful = true
        })
        .catch(error => {
          console.error('There was an error!', error);
          this.actionSuccessful = false
        });
    }
  },
  created() {
    this.fetchLoans()
  }
}
</script>

      