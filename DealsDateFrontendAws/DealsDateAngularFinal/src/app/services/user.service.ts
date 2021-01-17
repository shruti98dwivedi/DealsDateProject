import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { Userlogin } from '../models/userlogin';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private users: User[] = [];
  constructor(private http:HttpClient) { }

  getUser(id:number) :Observable<any>{
    return this.http.get("http://18.219.166.133:8080/getUserById/" + id);
  }
  
  updateMoblieNo(id:number,user:any) :Observable<any>{
    return this.http.put("http://18.219.166.133:8080/updatePhoneNumber/"+id,user);
  }
  
  updateFullName(id:number,user:any): Observable<any>{
  return this.http.put("http://18.219.166.133:8080/updateFullName/"+id,user);
  }

  public signup(user: User): Observable<any> {
    return this.http.post('http://18.219.166.133:8080/signUp', user, {responseType: 'text'});
  }
  public login(email: string, password: string, userLogin: Userlogin): Observable<any> {
    const url = 'http://18.219.166.133:8080/login/' + email + '/' + password;
    return this.http.post(url, userLogin, {responseType : 'text'});
  }
  public admin(email: string, password: string, userLogin: Userlogin): Observable<any> {
    const url = 'http://18.219.166.133:8080/admin/' + email + '/' + password;
    return this.http.post(url, userLogin, {responseType : 'text'});
  }
  loadUsers(): Observable<any> {
       return this.http.get('http://18.219.166.133:8080/getAllUserDetails');
  }
  setUsers(users: User[]): void {
    this.users = users;
  }
  getUsers(): User[] {
    return this.users;
  }
  deleteUserById(userId: number): Observable<any> {
    return this.http.delete('http://18.219.166.133:8080/deleteUser/' + userId, { responseType: 'text' });
  }
  getUserById(userId: number): Observable<any> {
    return this.http.get('http://18.219.166.133:8080/getUserById/' + userId);
  }
  updateUser(userId: number, value: any): Observable<any> {
    return this.http.put('http://18.219.166.133:8080/getUserById/' + userId, value);
  }

  logout(userId: number): Observable<any> {
    return this.http.put('http://18.219.166.133:8080/logout/' + userId, User );
  }
  getUserByEmail(email: String): Observable<User> {
    console.log('getuserbyemail log')
     let observable:Observable<User> = this.http.get<User>('http://18.219.166.133:8080/getUserByEmail/' + email);
     return observable
  }
  
  
}
