import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent  {

  user: User = new User();
  info: String;
  errorInfo: String;
  constructor(private userService: UserService, private route: Router) { }
  //ngOnInit(): void {
   // throw new Error('Method not implemented.');
  //}

  
  signUp() {
    console.log('signing in');
    this.userService.signup(this.user).subscribe(data => {
      this.user = data;

      console.log(this.user);
      this.info = data;
      this.route.navigate(['/login']);
      // alert(this.info + 'SignUp Successful');
      this.errorInfo = undefined;
      },
      error => {
        this.info = undefined;
        this.errorInfo = error.error;
        console.log(this.errorInfo);
        alert(this.errorInfo);
      } );
  }
  // ngOnInit(): void {
  //   // throw new Error("Method not implemented.");
  //   this.route.navigate(['/login']);
  // }
    onSubmit() {
        this.route.navigate(['/login']);
    }
    login() {
      this.route.navigate(['/login']);
    }
    home() {
      this.route.navigate(['/home']);
    }
    signup() {
      this.route.navigate(['/signup']);
    }

}
