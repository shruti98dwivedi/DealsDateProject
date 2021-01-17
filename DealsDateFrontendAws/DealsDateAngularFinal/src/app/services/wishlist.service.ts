import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  
  constructor(private http:HttpClient) {
  // this.baseUrl='http://localhost:8084/';
   }


 

 
  
  getWishList():Observable<any> {
    return this.http.get("http://18.219.166.133:8080/wishlist-service/wishlist/getwishlist");
  }

  removeFromWishList(id:number) :Observable<any> {
    return this.http.delete("http://18.219.166.133:8080/wishlist-service/wishlist/removefromwishlist/" + id);
  }
  
 
  addtoWishlist(id:number,product:Product)
  {
    return this.http.post("http://18.219.166.133:8080/wishlist-service/wishlist/addtowishlist/",product);
  }

}
