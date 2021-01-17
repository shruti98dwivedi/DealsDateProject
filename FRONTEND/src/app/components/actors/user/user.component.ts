import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { WishlistService } from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user:User;
  updateMN:boolean=false;
  updateFN:boolean=false;
  constructor(private service:UserService, private route:Router) {
    this.getUser();
   }

  ngOnInit(): void {
  }


  getUser()
  {
    this.service.getUser(7).subscribe(
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
    console.log(this.user.id);
    this.service.updateMoblieNo(this.user.id,this.user).subscribe(
      data=>{
        this.user=data;
        this.updateMN=false;
      },
      error=>{
        this.user=error.error;
      }
    )
  }


  updateFullName()
  {
    this.service.updateFullName(this.user.id,this.user).subscribe(
      data=>{
        this.user=data;
        this.updateFN=false;  
      },
      error=>{
        this.user=error.error;
      }
    )
  } 
}
