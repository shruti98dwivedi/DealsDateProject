import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }
  private orders: Order[] = [];
  private products: Product[] = [];

  baseOrderUrl="http://localhost:8084/admincontroller";

  /**
   * fires get request to server to fetch all order
   */

  fetchAllOrder():Observable<Order[]>
  {
    let url=this.baseOrderUrl;
    let observable:Observable<Order[]> =this.client.get<Order[]>(url);
    return observable;
  }

  /**
   * fires delete request to server to delete Order by id mentioned in url
   * @param id of order which has to be deleted
   */
  deleteOrderById(id:number){
    let url=this.baseOrderUrl+"/delete/"+id;
    let result:Observable<boolean>=this.client.delete<boolean>(url);
    return result;
  }

  

  /**
   * update Product by id mentioned in url
   * @param id of product which has to be update
   */
  updateProductById(product:Product){
    let url=this.baseOrderUrl+"/update/"+product.productId;
    let result:Observable<boolean>=this.client.put<boolean>(url,product);
    return result;
  }

  // updateProduct(productId: number, value: any): Observable<any> {
  //   return this.client.put('http://localhost:8084/getProductById/' + productId, value);
  // }

  /**
   * fires get request to server to fetch all products
   */

  fetchAllProduct():Observable<Product[]>
  {
    let url=this.baseOrderUrl+"/products/";
    let observable:Observable<Product[]> =this.client.get<Product[]>(url);
    return observable;
  }
  setOrders(orders: Order[]): void {
    this.orders = orders;
  }
  getOrders(): Order[] {
    return this.orders;
  }

  setProducts(product: Product[]): void {
    this.products = product;
  }
  getProducts(): Product[] {
    return this.products;
  }
}
