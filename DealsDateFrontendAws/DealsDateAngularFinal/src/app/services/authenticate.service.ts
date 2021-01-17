import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Userlogin } from '../models/userlogin';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  userLogin:Userlogin;
  msg:String;
  user:User;

  constructor(private service:UserService) { }

  logout(): void {
    console.log('removing local token' + localStorage.getItem('token'));
    console.log(this.userLogin);
    console.log(this.userLogin.id)
    this.service.logout(this.userLogin.id).subscribe(
      data=>{
        this.msg = data;
        console.log(this.msg);
        alert(this.msg);
      },
      error=>{
        this.msg=error.error;
        console.log(this.msg);
      }
    )

    
    this.userLogin = null;
    console.log(this.userLogin);
    localStorage.removeItem('token');
  }

  login(userLogin: Userlogin): void {
    
    console.log('setting local token ' + userLogin.email + userLogin.password + userLogin.id);
    this.userLogin = userLogin;
   
      localStorage.setItem('token', JSON.stringify(userLogin));
  }
  admin(userLogin: Userlogin): void {
    console.log('setting local token ' + userLogin.email + userLogin.password + userLogin.id );
    this.userLogin = userLogin;
    localStorage.setItem('token', JSON.stringify(userLogin));
  }
  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    if (token == null) {
      return false;
    }
    return true;
  }
}
