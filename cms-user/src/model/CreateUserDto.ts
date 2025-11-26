export interface IRoleDto {
    id?: string;
    name: string;
}

export interface ICreateUserDto {
    id?: string;
    loginId: string;
    fullName?: string;
    profileImg?: string;
    email?: string;
    telNo?: string;
    userCode?: string;
    note?: string;
    password: string;
    roleDto?: IRoleDto;
}

export class CreateUserDto {
    public id?: string;
    public loginId: string;
    public fullName?: string;
    public profileImg?: string;
    public email?: string;
    public telNo?: string;
    public userCode?: string;
    public note?: string;
    public password: string;
    public roleDto?: IRoleDto;

    constructor(data: {
        loginId: string;
        password: string;
        id?: string;
        fullName?: string;
        profileImg?: string;
        email?: string;
        telNo?: string;
        userCode?: string;
        note?: string;
        roleDto?: IRoleDto;
    }) {
        this.id = data.id?.trim();
        this.loginId = data.loginId.trim();
        this.fullName = data.fullName?.trim();
        this.profileImg = data.profileImg?.trim();
        this.email = data.email?.trim();
        this.telNo = data.telNo?.trim();
        this.userCode = data.userCode?.trim();
        this.note = data.note?.trim();
        this.password = data.password;
        this.roleDto = data.roleDto;
    }

    // Chuyển sang payload gửi API
    toPayload(): ICreateUserDto {
        return {
            id: this.id,
            loginId: this.loginId,
            fullName: this.fullName,
            profileImg: this.profileImg,
            email: this.email,
            telNo: this.telNo,
            userCode: this.userCode,
            note: this.note,
            password: this.password,
            roleDto: this.roleDto,
        };
    }
}
