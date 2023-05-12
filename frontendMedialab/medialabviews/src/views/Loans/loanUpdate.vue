<template>
  <main>
    <h1>Update a loan</h1>
    <form @submit.prevent="updateLoan">
      <div class="form-group">
        <label for="user">User</label>
        <select id="user" v-model="currentLoan.userId" class="form-control" @change="updateUser">
          <option v-for="user in users" :key="user.id" :value="user.id">{{ user.name }}</option>
        </select>
      </div>
      <div class="form-group">
        <label for="item">Item</label>
        <select id="item" v-model="currentLoan.itemId" class="form-control" @change="updateItem">
          <option v-for="item in items" :key="item.id" :value="item.id">{{ item.name }}</option>
        </select>
      </div>
      <div class="form-group">
        <label for="startDate">Start Date</label>
        <input type="date" id="startDate" v-model="currentLoan.startDate" class="form-control">
      </div>
      <div class="form-group">
        <label for="endDate">End Date</label>
        <input type="date" id="endDate" v-model="currentLoan.endDate" class="form-control">
      </div>
      <button type="submit" class="btn btn-primary">Update Loan</button>
    </form>
  </main>
</template>

<script>
import axios from 'axios'

export default {
data() {
  return {
    users: [],
    items: [],
    currentLoan: {
      userId: '',
      itemId: '',
      startDate: '',
      endDate: '',
    }
  }
},
methods: {
  fetchUsers() {
    axios.get('http://localhost:3333/api/users/allusers')
      .then(response => {
        this.users = response.data
        this.fetchLoan();
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  },
  fetchItems() {
    axios.get('http://localhost:3333/api/items')
      .then(response => {
        this.items = response.data
        this.fetchLoan();
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  },
  fetchLoan() {
    axios.get(`http://localhost:3333/api/loans/${this.$route.params.id}`)
      .then(response => {
        this.currentLoan = response.data;
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  },
  updateUser(event) {
    this.currentLoan.userId = event.target.value;
  },
  updateItem(event) {
    this.currentLoan.itemId = event.target.value;
  },
  updateLoan() {
    axios.put(`http://localhost:3333/api/loans/${this.$route.params.id}`, this.currentLoan)
      .then(() => {
        this.$router.push('/loans')
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  }
},
created() {
  this.fetchUsers();
  this.fetchItems();
  this.fetchLoan();  },
  mounted() {
    this.fetchLoan();
  },
  watch: {
    '$route.params.id': {
      immediate: true,
      handler(newVal) {
        this.fetchLoan(newVal);
      },
    },
  },
}
</script>

