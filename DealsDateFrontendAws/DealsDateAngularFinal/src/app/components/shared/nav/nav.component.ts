import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticateService } from 'src/app/services/authenticate.service';
import { ProductlistService } from 'src/app/services/productlist.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  categoriesList:String[];
  categoryName:any;
  isActive:boolean=true;
  header_variable: boolean=false;
  route: any;
  
  constructor(private router:Router,private service:ProductlistService,private authService: AuthenticateService) { }

  ngOnInit(): void {
    this.loadCategoryList();
  }

  loadCategoryList(){
    this.service.getCategoryList().subscribe(
      (data)=>{
        this.categoriesList=data;
      }
    )
     
  }

  goToShoppingCart(){
      this.isActive=false;
      this.router.navigate(['productlist',this.categoryName]);

    }



    @HostListener("document:scroll")
scrollFunction(){
if(document.body.scrollTop>0 || document.documentElement.scrollTop>0){
this.header_variable=true;
}
else{
this.header_variable=false;
}
}

logout() {
  console.log('in the nav logout');
  this.authService.logout();

}
}
