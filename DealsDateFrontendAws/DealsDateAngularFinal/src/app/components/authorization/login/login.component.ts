import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/models/user';
import { Userlogin } from 'src/app/models/userlogin';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {

  userLogin: Userlogin = new Userlogin();
  user:User =null;
  email: String;
  password: String; 
  id:number;
  info: string;
  errorInfo: string;
  constructor(private userService: UserService, private route: Router, private authService: AuthenticateService) { }
 


  
  login() {
    console.log('User logging in');
    console.log(this.userLogin.email);
    console.log(this.userLogin.password);
    this.userService.login(this.userLogin.email, this.userLogin.password, this.userLogin).subscribe(data => {
      this.info = data;
      this.route.navigate(['/home']);
      this.getUserByEmail();
      // alert(this.info);
      },

      error => {
        this.info = undefined;
        this.errorInfo = error.error;
       
       console.log(+this.errorInfo);
        alert('Wrong username or password');
        this.route.navigateByUrl('/login');
      } );
    
   
  }
  // ngOnInit(): void {
  //   this.route.navigate(['/home']);
  // }

  getUserByEmail(){
    this.userService.getUserByEmail(this.userLogin.email).subscribe( data=>{
      this.user=data;
      console.log('user details'+this.user);
      console.log('user '+this.user.userId)
      this.userLogin.id = this.user.userId;
      console.log('userLogin '+this.userLogin.id)
      this.authService.login(this.userLogin);
    },
error=>{
  this.user=error.error;
  console.log('some error in fetching data')
}
      );

  }
    onSubmit() {
      this.route.navigate(['/home']);
  }
  signup() {
    this.route.navigate(['/signup']);
  }
  login2() {
    this.route.navigate(['/login']);
  }
  home() {
    this.route.navigate(['/home']);
  }
  
  
  
} 
