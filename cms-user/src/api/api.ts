import axios from 'axios';
import {authService} from "../service/AuthService.ts";

const api = axios.create({
    baseURL: import.meta.env.VITE_ROOT_API + '/api',
});

api.interceptors.request.use(
    config => {
        const token = authService.getToken();
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    error => Promise.reject(error)
);

export default api;
