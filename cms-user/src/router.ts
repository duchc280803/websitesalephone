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
import Product from './pages/product/Product.vue'
import Order from './pages/order/Order.vue'
import OrderDetailPage from './pages/order/OrderDetailPage.vue'
import HomePage from "./pages/home/HomePage.vue";
import OrderOfUSer from "./pages/home/OrderOfUSer.vue";
import OrderDetailByUser from "./pages/home/OrderDetailByUser.vue";
import LoginPageCustomer from "./pages/LoginPage.vue";
import RegisterPage from "./pages/RegisterPage.vue";
import {authService} from "./service/AuthService.ts";
import ProductDetailPage from "./pages/product/ProductDetailPage.vue";
import UserProfile from "./pages/home/UserProfile.vue";

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
                    path: 'detail-product/:id',
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
                    path: 'order-detail/:id',
                    name: 'OrderDetailByUser',
                    component: OrderDetailByUser,
                    meta: { requiresAuth: false, title: 'Đơn hàng user' }
                },
                {
                    path: 'user-profile',
                    name: 'UserProfile',
                    component: UserProfile,
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
                    path: 'create-user',
                    name: 'CreateUserPage',
                    component: UserDetailPage,
                    meta: { requiresAuth: true, title: 'Create User' }
                },
                {
                    path: 'product',
                    name: 'product',
                    component: Product,
                    meta: { requiresAuth: true, title: 'Sản phẩm' }
                },
                {
                    path: 'product-detail/:id',
                    name: 'ProductDetailPage',
                    component: ProductDetailPage,
                    meta: { requiresAuth: true, title: 'Sản phẩm' }
                },
                {
                    path: 'create-product',
                    name: 'CreateProduct',
                    component: ProductDetailPage,
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

router.beforeEach((to, from, next) => {
    const isAuth = authService.isAuthenticated();
    if (isAuth) {
        const role = authService.getRole();
        if (to.name === undefined) {
            return next({ path: '/customer/' });
        }
        if (to.name === 'LoginPageCustomer' || to.name === 'RegisterPage') {
            if (role === 'CUSTOMER') return next({ path: '/customer/home' });
            else return next({ path: '/admin/dashboard' });
        }
    } else {
        if (to.meta.requiresAuth) {
            return next({ name: 'LoginPageCustomer' });
        }
    }

    next();
});

router.afterEach((to) => {
    document.title = to.meta.title ?? 'App'
})

export default router
