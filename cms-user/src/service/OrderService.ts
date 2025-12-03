import axios, { AxiosResponse } from 'axios';
import type {Search} from "../models/Search.ts";
import type {OrderRequest} from "../models/OrderRequest.ts";
import api from "../api/api.ts";

class OrderService {
    private ROOT_API = import.meta.env.VITE_ROOT_API + '/api/order/';

    public search(orderSearch: Search): Promise<AxiosResponse> {
        return api.post(`${this.ROOT_API}search`, orderSearch);
    }

    public detail(id: string): Promise<AxiosResponse> {
        return api.get(`${this.ROOT_API}detail/${id}`);
    }

    public update(orderRequest: OrderRequest): Promise<AxiosResponse> {
        return api.put(`${this.ROOT_API}update`, orderRequest);
    }
}

export const orderService = new OrderService();
