<template>
  <main class="container mt-5">
    <h1 class="mb-4">Add a new loan</h1>
    <form @submit.prevent="addLoan">
      <div class="form-group">
        <label for="user">User</label>
        <select id="user" v-model="newLoan.userId" class="form-control" @change="updateUser" required>
          <option v-for="user in users" :key="user.id" :value="user.id">{{ user.name }}</option>
        </select>
      </div>
      <div class="form-group mt-4">
        <label for="item">Item</label>
        <select id="item" v-model="newLoan.itemId" class="form-control" @change="updateItem" required>
          <option v-for="item in items" :key="item.id" :value="item.id">{{ item.name }}</option>
        </select>
      </div>
      <div class="form-group mt-4">
        <label for="startDate">Start Date</label>
        <input id="startDate" v-model="newLoan.startDate" type="date" class="form-control" required>
      </div>
      <div class="form-group mt-4">
        <label for="endDate">End Date</label>
        <input id="endDate" v-model="newLoan.endDate" type="date" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary mt-4">Add Loan</button>
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
        newLoan: {
          userId: '',
          itemId: '',
          startDate: '',
          endDate: ''
        }
      }
    },
    methods: {
      fetchUsers() {
        axios.get('http://localhost:3333/api/users/allusers')
          .then(response => {
            this.users = response.data
            console.log(response);
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
      },
      fetchItems() {
        axios.get('http://localhost:3333/api/items')
          .then(response => {
            this.items = response.data
            //console.log(response);
          })
          .catch(error => {
            console.error('There was an error!', error);
          });
      },
      updateUser(event) {
        this.newLoan.userId = event.target.value;
      },
      updateItem(event) {
        this.newLoan.itemId = event.target.value;
      },
      addLoan() {
        axios.post('http://localhost:3333/api/loans', this.newLoan)
          .then(() => {
            this.$router.push('/loans')
          })
          .catch(error => {
            console.error('There was an error!', error);
        });
    },
  },
  created() {
    this.fetchUsers();
    this.fetchItems();
  }
}
</script>

  