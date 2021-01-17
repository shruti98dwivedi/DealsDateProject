export class User {


    id:number;
    email:string;
    firstname:string;
    lastname:string;
    password:string;
    confirmPassword:string;
    phoneNumber:string;
    userType:type;
    loginStatus:login;
    userId: number;
}

export enum type{
    admin,user
}

export enum login{
    LoggedIn,LoggedOut
}