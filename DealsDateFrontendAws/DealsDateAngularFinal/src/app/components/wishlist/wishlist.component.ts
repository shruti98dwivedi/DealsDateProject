import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Product } from 'src/app/models/product';
import { Wishlist } from 'src/app/models/wishlist';
import { CartService } from 'src/app/services/cart.service';
import { ProductlistService } from 'src/app/services/productlist.service';
import { WishlistService } from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {


  wishlist:Wishlist[]=[]
  errorinfo:any;
  orders:any;
  message:any;
  constructor(private service:WishlistService,private cartService:CartService,private toastr:ToastrService,
     private route:Router,private productService:ProductlistService) {
    this.getProducts();
   }

  ngOnInit(): void {
  }

  getProducts()
  {
    this.service.getWishList().subscribe(
      data=>{
        this.wishlist=data;
        console.log(this.wishlist);
      },
  error=>{
    this.errorinfo=error.error;
  }
  );
  }

  removeFromWishList(wishlistId:number)
  {
    this.service.removeFromWishList(wishlistId).subscribe(data=>{
      this.message=data;
      this.getProducts();
    },
    error=>{
        this.errorinfo=error.error;
        this.getProducts();
    }
    );
  }

  addToCart(productId:number,product:Product){
    this.cartService.addtoCart(productId,product).subscribe(
      (data)=>{
        this.message=data
      },
      error=>{
        this.errorinfo=error.error();}
    )

    this.toastr.success('Item Added To The Cart Successfully..!!','YEEHHHHHHH..',{
      timeOut:1000,
      progressBar:true,
      progressAnimation:'increasing',
    })
  }
}
