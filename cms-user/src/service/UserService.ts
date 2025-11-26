import Vue from 'vue';

class UserService {
    private ROOT_API = process.env.VUE_APP_ROOT_API + '/';

}

export const userService = new UserService()