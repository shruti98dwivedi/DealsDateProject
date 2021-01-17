import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Userlogin } from 'src/app/models/userlogin';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  userLogin: Userlogin = new Userlogin();
  email: String;
  password: String; 
  info: string;
  errorInfo: string;
  
  constructor(private userService: UserService, private route: Router, private authService: AuthenticateService) { }
 
  ngOnInit(): void {
   
  }

  admin() {
    console.log(' admin logging in');
    console.log(this.userLogin.email);
    console.log(this.userLogin.password);
    this.authService.admin(this.userLogin);
    this.userService.admin(this.userLogin.email, this.userLogin.password, this.userLogin).subscribe(data => {
      this.info = data;
      this.route.navigate(['/admincontroller']);
      // alert(this.info);
      },

      error => {
        this.info = undefined;
        this.errorInfo = error.error;
        console.log(this.errorInfo);
        alert(this.errorInfo);
      } );
  }
    onSubmit() {
      this.route.navigate(['/admin/admincontrol']);
    }
    logout() {
      this.authService.logout();
      this.route.navigateByUrl('/login');
    }
 
}
