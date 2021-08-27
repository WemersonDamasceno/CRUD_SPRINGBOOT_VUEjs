import Vue from 'vue'
import VueRouter from 'vue-router'
import Formulario from '../views/Formulario.vue'
import Pagina_Inicial from '../views/Pagina_Inicial.vue'
import Listar_Produto from '../views/Listar_Produto.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Pagina Inicial',
    component: Pagina_Inicial
  },
 
  {
    path: '/formulario',
    name: 'Formulario',
    component: Formulario
  },
 
  {
    path: '/produtos',
    name: 'Listar Produtos',
    component: Listar_Produto
  },
 

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
