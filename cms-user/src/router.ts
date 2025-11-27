import { createRouter, createWebHistory } from 'vue-router'

// Customer pages
import DetailProductHome from './pages/home/DetailProductHome.vue'
import Cart from './pages/home/Cart.vue'
import HomeProduct from './pages/home/HomeProduct.vue'

// Admin pages
import AdminLayout from './layout/AdminLayout.vue'
import AdminPage from './pages/dashboard.vue'
import User from './pages/user/User.vue'
import UserDetailPage from './pages/user/UserDetailPage.vue'
import Product from './pages/Product.vue'
import Order from './pages/order/Order.vue'
import OrderDetailPage from './pages/order/OrderDetailPage.vue'
import HomePage from "./pages/home/HomePage.vue";
import OrderOfUSer from "./pages/home/OrderOfUSer.vue";
import OrderDetailByUser from "./pages/home/OrderDetailByUser.vue";
import LoginPageCustomer from "./pages/LoginPageCustomer.vue";
import RegisterPage from "./pages/RegisterPage.vue";

const router = createRouter({
    history: createWebHistory(),
    scrollBehavior(to, from, savedPosition) {
        return savedPosition ? savedPosition : { left: 0, top: 0 }
    },
    routes: [
        {
            path: '/login',
            name: 'LoginPageCustomer',
            component: LoginPageCustomer,
            meta: { requiresAuth: false, title: 'Login' }
        },
        {
            path: '/register',
            name: 'RegisterPage',
            component: RegisterPage,
            meta: { requiresAuth: false, title: 'Register' }
        },
        {
            path: '/customer',
            redirect: '/customer/home',
            children: [
                {
                    path: 'home',
                    name: 'home',
                    component: HomePage,
                    meta: { requiresAuth: false, title: 'Home' }
                },
                {
                    path: 'detail-product',
                    name: 'DetailProductHome',
                    component: DetailProductHome,
                    meta: { requiresAuth: false, title: 'Chi tiết sản phẩm' }
                },
                {
                    path: 'cart',
                    name: 'cart',
                    component: Cart,
                    meta: { requiresAuth: false, title: 'Giỏ hàng' }
                },
                {
                    path: 'product-home',
                    name: 'HomeProduct',
                    component: HomeProduct,
                    meta: { requiresAuth: false, title: 'Sản phẩm' }
                },
                {
                    path: 'order-by-user',
                    name: 'OrderOfUSer',
                    component: OrderOfUSer,
                    meta: { requiresAuth: false, title: 'Đơn hàng user' }
                },
                {
                    path: 'order-detail',
                    name: 'OrderDetailByUser',
                    component: OrderDetailByUser,
                    meta: { requiresAuth: false, title: 'Đơn hàng user' }
                }
            ]
        },
        {
            path: '/admin',
            component: AdminLayout,
            redirect: '/admin/dashboard',
            children: [
                {
                    path: 'dashboard',
                    name: 'dashboard',
                    component: AdminPage,
                    meta: { requiresAuth: true, title: 'Dashboard' }
                },
                {
                    path: 'user',
                    name: 'user',
                    component: User,
                    meta: { requiresAuth: true, title: 'Người dùng' }
                },
                {
                    path: 'user-detail/:id',
                    name: 'UserDetailPage',
                    component: UserDetailPage,
                    meta: { requiresAuth: true, title: 'Chi tiết người dùng' }
                },
                {
                    path: 'product',
                    name: 'product',
                    component: Product,
                    meta: { requiresAuth: true, title: 'Sản phẩm' }
                },
                {
                    path: 'order',
                    name: 'order',
                    component: Order,
                    meta: { requiresAuth: true, title: 'Đơn hàng' }
                },
                {
                    path: 'orders-detail/:id',
                    name: 'OrderDetailPage',
                    component: OrderDetailPage,
                    meta: { requiresAuth: true, title: 'Chi tiết đơn hàng' }
                }
            ]
        }
    ]
})

router.afterEach((to) => {
    document.title = to.meta.title ?? 'App'
})

export default router
