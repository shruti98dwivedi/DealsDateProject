import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CartItem } from 'src/app/models/cart-item';
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

  carts: CartItem[]=[];
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
    this.service.getCartItem().subscribe(
      data=>{
        this.carts=data;
      },
  error=>{
    this.errorinfo=error.error;
  }
  );
  }
   
  removeFromCart(cartItemId:number)
  {
    this.service.removeCartItems(cartItemId).subscribe(data=>{
      this.message=data;
      this.getProducts();
    },
    error=>{
        this.errorinfo=error.error;
        this.getProducts();
    }
    );

  }


  CartItemQuantity:number=1;
  i=1
  plus(){
    if(this.i !=5){
      this.i++;
      this.CartItemQuantity=this.i;
    }
  }
  minus(){
    if(this.i !=1){
      this.i--;
      this.CartItemQuantity=this.i;
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
