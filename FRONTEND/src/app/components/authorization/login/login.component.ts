import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
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
  email: String;
  password: String; 
  info: string;
  errorInfo: string;
  constructor(private userService: UserService, private route: Router, private authService: AuthenticateService) { }
 


  
  login() {
    console.log('User logging in');
    console.log(this.userLogin.email);
    console.log(this.userLogin.password);
    this.authService.login(this.userLogin);
    this.userService.login(this.userLogin.email, this.userLogin.password, this.userLogin).subscribe(data => {
      this.info = data;
      this.route.navigate(['/home']);
      // alert(this.info);
      },

      error => {
        this.info = undefined;
        this.errorInfo = error.error;
        console.log(this.errorInfo);
        alert(this.errorInfo);
        this.route.navigateByUrl('/login');
      } );
  }
  // ngOnInit(): void {
  //   this.route.navigate(['/home']);
  // }
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
