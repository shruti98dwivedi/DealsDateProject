import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  


  
  constructor(private http:HttpClient) { }

  addToCartItem(productId:number,product:Product){
    return this.http.post("http://localhost:8084/cartitems/addtocartitems/"+productId,product);
  }



  getCartItem():Observable<any> {
    return this.http.get("http://localhost:8084/cartitems/viewcartitem");
  }
 
  removeCartItems(id:number) :Observable<any> {
    return this.http.delete("http://localhost:8084/cartitems/deletecartitem/" + id);
  }
}
