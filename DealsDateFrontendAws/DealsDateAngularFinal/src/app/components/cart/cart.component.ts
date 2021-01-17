import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cart } from 'src/app/models/cart';
import { Product } from 'src/app/models/product';

import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';
import { ProductlistService } from 'src/app/services/productlist.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  carts: Cart[]=[];
  cartValue:number;
  cartCount:number;
  updatedQuantity:number;
  productId:number;
  errorinfo: any;
  message: any;


  constructor(private service:CartService,
     private router: Router,
     private productService:ProductlistService,private orderservice:OrderService,private toastr:ToastrService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts()
  {
    this.service.getCart().subscribe(
      data=>{
        this.carts=data;
      },
  error=>{
    this.errorinfo=error.error;
  }
  );
  }
   
  removeFromCart(cartId:number)
  {
    this.service.removeFromCart(cartId).subscribe(data=>{
      this.message=data;
      this.getProducts();
    },
    error=>{
        this.errorinfo=error.error;
        this.getProducts();
    }
    );

  }


  CartQuantity:number=1;
  i=1
  plus(){
    if(this.i !=5){
      this.i++;
      this.CartQuantity=this.i;
    }
  }
  minus(){
    if(this.i !=1){
      this.i--;
      this.CartQuantity=this.i;
    }
  }
  addToOrder(product:Product){
    this.orderservice.addToOrder(product.productId,product).subscribe(
      (data)=>{
        this.message=data
      },
      error=>{
        this.errorinfo=error.error();}
    )

    this.toastr.success('Order Placed Successfully..!!','YEEHHHHHHH..',{
      timeOut:1000,
      progressBar:true,
      progressAnimation:'increasing',
    })
  }



  
}
