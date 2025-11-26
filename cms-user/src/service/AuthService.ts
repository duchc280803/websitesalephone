import axios, { AxiosResponse } from 'axios';
import { AuthUser, IAuthUser } from '@/models/AuthUser';
import { ResetPasswordRequest, IResetPasswordRequest } from '@/models/ResetPasswordRequest';

class AuthService {
    private ROOT_API = process.env.VUE_APP_ROOT_API + '/api/auth/';

    // Login
    public login(request: AuthUser | IAuthUser): Promise<AxiosResponse> {
        const payload = request instanceof AuthUser ? request.toAuthPayload() : request;
        return axios.post(`${this.ROOT_API}login`, payload);
    }

    // Logout
    public logout(token: string): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}logout`, null, { params: { token } });
    }

    // Quên mật khẩu
    public forgotPassword(email: string, tabletOrPc: string): Promise<AxiosResponse> {
        return axios.post(`${this.ROOT_API}forgot-password`, null, {
            params: { email, tabletOrPc }
        });
    }

    // Reset mật khẩu
    public resetPassword(request: ResetPasswordRequest | IResetPasswordRequest): Promise<AxiosResponse> {
        const payload = request instanceof ResetPasswordRequest ? request.toPayload() : request;
        return axios.post(`${this.ROOT_API}reset-password`, payload);
    }

    // Kiểm tra token reset mật khẩu
    public checkResetToken(token: string): Promise<AxiosResponse> {
        return axios.get(`${this.ROOT_API}check-reset-token`, { params: { token } });
    }
}

export const authService = new AuthService();
