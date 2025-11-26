import axios, { AxiosResponse } from 'axios';
import {CreateUserDto} from "../model/CreateUserDto.ts";
import type {UserSearchForm} from "../model/UserSearchForm.ts";

class UserService {
    private ROOT_API = process.env.VUE_APP_ROOT_API + '/api/user/';

    public getUserByLoginId(loginId: string): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}get-user-by-login/${loginId}`);
    }

    public createUser(createUserDto: CreateUserDto): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}create`, createUserDto);
    }

    public updateUser(updateUserDto: CreateUserDto): Promise<AxiosResponse> {
        return axios.put(`${this.ROOT_API}update`, updateUserDto);
    }

    public deleteUser(userId: string): Promise<AxiosResponse> {
        return axios.put(`${this.ROOT_API}delete/${userId}`);
    }

    public search(searchForm: UserSearchForm): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}search`, searchForm);
    }
}

export const userService = new UserService();
