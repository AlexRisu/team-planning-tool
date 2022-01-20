import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: () => import('../views/Home')

    },
    {
        path: '/about',
        name: 'About',
        component: () => import('../views/About')
    },
    {
        path: '/profile',
        name: 'Profile',
        component: () => import('../views/Profile')
    },
    {
        path: '/calendar',
        name: 'Calendar',
        component: () => import('../views/CalendarManager')
    },
]

const router = new VueRouter({
    routes
})

export default router
