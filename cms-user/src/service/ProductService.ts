import axios, { AxiosResponse } from 'axios';
import type {Search} from "../models/Search.ts";
import type {ProductRequest} from "../models/ProductRequest.ts";
import type {ProductDetailRequest} from "../models/ProductDetailRequest.ts";
import type {CreateCartRequest} from "../models/CreateCartRequest.ts";
import api from "../api/api.ts";

class ProductService {
    private ROOT_API = import.meta.env.VITE_ROOT_API + '/api/product/';

    public search(productSearch: Search): Promise<AxiosResponse> {
        return api.post(`${this.ROOT_API}search`, productSearch);
    }

    public create(productRequest: ProductRequest): Promise<AxiosResponse> {
        return api.post(`${this.ROOT_API}create`, productRequest);
    }

    public update(productRequest: ProductRequest): Promise<AxiosResponse> {
        return api.put(`${this.ROOT_API}update`, productRequest);
    }

    public delete(id: string): Promise<AxiosResponse> {
        return api.put(`${this.ROOT_API}deleted/${id}`);
    }

    public detail(productDetailRequest: ProductDetailRequest): Promise<AxiosResponse> {
        return api.post(`${this.ROOT_API}detail`,productDetailRequest);
    }

    public getQuantity(cartRequest: CreateCartRequest): Promise<AxiosResponse> {
        return api.post(`${this.ROOT_API}get-quantity`,cartRequest);
    }
}

export const productService = new ProductService();
