import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PackageListView from '../views/PackageListView.vue'
import ProductDetail from '../views/ProductDetail.vue'


const routes = [
    { path: '/', name: 'Home', component: HomeView },
    { path: '/package', name: 'PackageList', component: PackageListView },
    { path: '/package/detail/:id', name: 'ProductDetail', component: ProductDetail }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
