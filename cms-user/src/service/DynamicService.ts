import axios, { AxiosResponse } from 'axios';
import type {DynamicSearch} from "../model/DynamicSearch.ts";
import type {DynamicRequest} from "../model/DynamicRequest.ts";

class DynamicService {
    private ROOT_API = process.env.VUE_APP_ROOT_API + '/api/dynamic/';

    public search(dynamicSearch: DynamicSearch): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}search`, dynamicSearch);
    }

    public create(dynamicRequest: DynamicRequest): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}create`, dynamicRequest);
    }

    public update(dynamicRequest: DynamicRequest): Promise<AxiosResponse> {
        return axios.put(`${this.ROOT_API}update`, dynamicRequest);
    }

    public delete(dynamicRequest: DynamicRequest): Promise<AxiosResponse> {
        return axios.delete(`${this.ROOT_API}delete`, { data: dynamicRequest });
    }
}

export const dynamicService = new DynamicService();
