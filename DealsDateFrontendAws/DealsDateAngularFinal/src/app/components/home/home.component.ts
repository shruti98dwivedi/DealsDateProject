import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { ProductlistService } from 'src/app/services/productlist.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})



export class HomeComponent implements OnInit {


  
  

  constructor(private router:Router) {
   }

  ngOnInit(): void {
   
  }

  


  
}
