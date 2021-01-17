import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  


  
  constructor(private http:HttpClient) { }

  addtoCart(productId:number,product:Product){
    return this.http.post("http://18.219.166.133:8080/cart-service/cart/addtocart/",product);
  }s



  getCart():Observable<any> {
    return this.http.get("http://18.219.166.133:8080/cart-service/cart/getcart");
  }
 
  removeFromCart(id:number) :Observable<any> {
    return this.http.delete("http://18.219.166.133:8080/cart-service/cart/removefromcart/" + id);
  }
}
