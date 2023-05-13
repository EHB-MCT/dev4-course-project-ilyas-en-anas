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

import UserView from '../views/Users/View.vue'
//import UserUpdate from '../views/Users/userUpdate.vue'
import UserAdd from '../views/Users/userAdd.vue'

//import SignupView from '../views/SignUpView.vue'
import LoginView from '../views/LoginView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
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
    /*{
      path: '/userupdate/:id',
      name: 'userupdate',
      component: UserUpdate,
      props: true
    }*/
    {
      path: '/useradd',
      name: 'useradd',
      component: UserAdd
    },
    //sign
    /* {
      path: '/',
      name: 'signup',
      component: SignupView
    },*/
    {
      path: '/login',
      name: 'login',
      component: LoginView
    }
  ]
})

router.beforeEach((to, from, next) => {
  const publicPages = ['/login']
  const authRequired = !publicPages.includes(to.path)
  const loggedIn = localStorage.getItem('loggedInUser')

  if (authRequired && !loggedIn) {
    return next('/login')
  }

  next()
})

export default router
