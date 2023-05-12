import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ItemView from '../views/Items/View.vue'
import ItemDetail from '../views/Items/ItemDetail.vue'
import ItemUpdate from '../views/Items/ItemUpdate.vue'
import ItemAdd from '../views/Items/ItemAdd.vue'

import LoanView from '../views/Loans/View.vue'
import LoanDetail from '../views/Loans/loanDetail.vue'
import LoanUpdate from '../views/Loans/loanUpdate.vue'
import LoanAdd from '../views/Loans/loanAdd.vue'

import SignupView from '../views/SignUpView.vue'
import LoginView from '../views/LoginView.vue'
import UserView from '../views/Users/View.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    //items
    {
      path: '/items',
      name: 'items',
      component: ItemView
    },
    {
      path: '/itemdetail/:id',
      name: 'itemdetail',
      component: ItemDetail,
      props: true
    },
    {
      path: '/itemupdate/:id',
      name: 'itemupdate',
      component: ItemUpdate,
      props: true
    },
    {
      path: '/itemadd',
      name: 'itemadd',
      component: ItemAdd
    },
    //loans
    {
      path: '/loans',
      name: 'loans',
      component: LoanView
    },
    {
      path: '/loandetail/:id',
      name: 'loandetail',
      component: LoanDetail,
      props: true
    },
    {
      path: '/loanupdate/:id',
      name: 'loanupdate',
      component: LoanUpdate,
      props: true
    },
    {
      path: '/loanadd',
      name: 'loanadd',
      component: LoanAdd
    },
    //users
    {
      path: '/users',
      name: 'users',
      component: UserView
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignupView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    }
  ]
})

export default router
