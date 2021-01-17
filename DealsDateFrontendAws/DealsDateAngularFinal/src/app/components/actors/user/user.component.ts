import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { UserService } from 'src/app/services/user.service';
import { WishlistService } from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user:User;
  id:number;
  updateMN:boolean=false;
  updateFN:boolean=false;
  constructor(private service:UserService, private route:Router, private authService: AuthenticateService) {
    this.getUser();
   }

  ngOnInit(): void {
  }


  getUser()
  {
    this.id = this.authService.userLogin.id;
    console.log('getuser() '+this.id)
    this.service.getUser(this.id).subscribe(
      data=>{
        this.user=data;
        console.log(this.user);
      },
  error=>{
    this.user=error.error;
  }
  );
  }
  
  
  updateMobForm()
  {
    this.updateMN=true;
    this.updateFN=false;
  }
  
  updateFullNameForm()
  {
    this.updateFN=true;
    this.updateMN=false;
  }
  
  
  updateMobileNo()
  {
    console.log(this.user.userId);
    this.service.updateMoblieNo(this.user.userId,this.user).subscribe(
      data=>{
        this.user=data;
        this.updateMN=false;
        alert('Mobile No. updated successfully!!')
      },
      error=>{
        this.user=error.error;
      }
    )
  }


  updateFullName()
  {
    console.log(+this.user.userId);
    this.service.updateFullName(this.user.userId, this.user).subscribe(
      data=>{
        this.user=data;
        this.updateFN=false;
        alert('FullName updated successfully!!')  
      },
      error=>{
        this.user=error.error;
      }
    )
  } 
}
