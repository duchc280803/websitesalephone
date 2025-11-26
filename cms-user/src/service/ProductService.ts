import axios, { AxiosResponse } from 'axios';
import type {Search} from "../model/Search.ts";
import type {ProductRequest} from "../model/ProductRequest.ts";
import type {ProductDetailRequest} from "../model/ProductDetailRequest.ts";

class ProductService {
    private ROOT_API = process.env.VUE_APP_ROOT_API + '/api/product/';

    public search(productSearch: Search): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}search`, productSearch);
    }

    public create(productRequest: ProductRequest): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}create`, productRequest);
    }

    public update(productRequest: ProductRequest): Promise<AxiosResponse> {
        return axios.put(`${this.ROOT_API}update`, productRequest);
    }

    public delete(id: string): Promise<AxiosResponse> {
        return axios.put(`${this.ROOT_API}deleted/${id}`);
    }

    public detail(productDetailRequest: ProductDetailRequest): Promise<AxiosResponse> {
        return axios.get(`${this.ROOT_API}detail`, {
            params: productDetailRequest,
        });
    }
}

export const productService = new ProductService();
