import { Injectable } from '@angular/core';
import { Userlogin } from '../models/userlogin';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor() { }

  logout(): void {
    console.log('removing local token' + localStorage.getItem('token'));
    localStorage.removeItem('token');
  }

  login(userLogin: Userlogin): void {
    console.log('setting local token ' + userLogin.email + userLogin.password);
    localStorage.setItem('token', JSON.stringify(userLogin));
  }
  admin(userLogin: Userlogin): void {
    console.log('setting local token ' + userLogin.email + userLogin.password );
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
