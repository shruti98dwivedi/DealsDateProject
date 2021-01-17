import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
 

  constructor(private httpClient:HttpClient) {
    
   }


 
 addToOrder(productId:number,product:Product):Observable<String>
 {
   return this.httpClient.post<String>('http://18.219.166.133:8080/orders/placeorder' + productId, product);
 }
}
