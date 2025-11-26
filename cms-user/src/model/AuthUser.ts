export interface IAuthUser {
    loginId: string;
    password: string;
}

export class AuthUser {
    public loginId: string;
    public password: string;

    constructor(loginId: string, password: string) {
        this.loginId = loginId.trim();
        this.password = password.trim();
    }

    // Lấy password (có thể encode nếu cần ở frontend, ví dụ Base64)
    getPassword(): string | null {
        return this.password ? this.password : null;
    }

    // Lấy password nguyên bản
    getPasswordLogin(): string | null {
        return this.password ? this.password : null;
    }

    // Chuyển sang object dùng cho login API
    toAuthPayload(): IAuthUser {
        return {
            loginId: this.loginId,
            password: this.password,
        };
    }
}
