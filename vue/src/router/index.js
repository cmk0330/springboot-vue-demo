import {createRouter, createWebHistory} from 'vue-router'
import Layout from '../layout/Layout.vue'

const routes = [
    {
        path: '/',
        name: 'Layout',
        redirect: "/home",
        component: Layout,
        children: [
            {
                path: "home",
                name: "Home",
                component: () => import("@/views/Home")
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login")
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
