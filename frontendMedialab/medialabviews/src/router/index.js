import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ItemView from '../views/Items/View.vue'
import ItemDetail from '../views/Items/ItemDetail.vue'
import ItemUpdate from '../views/Items/ItemUpdate.vue'
import ItemAdd from '../views/Items/ItemAdd.vue'
import UserView from '../views/Users/View.vue'
import LoanView from '../views/Loans/View.vue'
import SignupView from '../views/SignUpView.vue'
import LoginView from '../views/LoginView.vue'

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
    //users
    {
      path: '/users',
      name: 'users',
      component: UserView
    },
    //loans
    {
      path: '/loans',
      name: 'loans',
      component: LoanView
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
