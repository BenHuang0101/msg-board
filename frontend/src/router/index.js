import { createRouter, createWebHistory } from 'vue-router'
import MessageBoard from '../components/MessageBoard.vue'

const routes = [
  { path: '/', component: MessageBoard }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
