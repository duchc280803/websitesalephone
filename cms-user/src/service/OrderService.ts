import axios, { AxiosResponse } from 'axios';
import type {Search} from "../models/Search.ts";
import type {OrderRequest} from "../models/OrderRequest.ts";

class OrderService {
    private ROOT_API = process.env.VUE_APP_ROOT_API + '/api/order/';

    public search(orderSearch: Search): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}search`, orderSearch);
    }

    public detail(id: string): Promise<AxiosResponse> {
        return axios.get(`${this.ROOT_API}detail/${id}`);
    }

    public update(orderRequest: OrderRequest): Promise<AxiosResponse> {
        return axios.put(`${this.ROOT_API}update`, orderRequest);
    }
}

export const orderService = new OrderService();
