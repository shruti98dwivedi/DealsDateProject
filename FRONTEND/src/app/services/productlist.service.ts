import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductlistService {

  private baseUrl:string;

  constructor(private httpClient:HttpClient) {
  //  this.baseUrl=`${environment.baseMWUrl}/home`
  this.baseUrl='http://localhost:8084/home'
 // this.baseUrl='http://localhost:8888/product-service/home'
 //this.baseUrl='http://localhost:8002/home'
   }

   getCategoryList():Observable<String[]>{
    return this.httpClient.get<String[]>(`${this.baseUrl}/listofcategories`);
   }

  getListOfProducts():Observable<Product[]>{
    
    return this.httpClient.get<Product[]>(`${this.baseUrl}/displaylistofproducts`);
  }

  getListOfProductsBasedOnCategory(categoryName:any):Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>(`${this.baseUrl}/fetchlistofproductsbycategory/${categoryName}`)+"Servicesssss");
    return this.httpClient.get<Product[]>(`${this.baseUrl}/fetchlistofproductsbycategory/${categoryName}`);
  }

  getListOfSortedProductAsc():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofsortedproductsasc`);
  }

  getListOfSortedProductDesc():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofsortedproductsdesc`);
  }

  

  getListOfProductsBasedOnCategorySortedByPriceDesc(categoryName:any):Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesortingdesc/${categoryName}`)+"Servicesssss Desc");
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesortingdesc/${categoryName}`);
  }

  getListOfProductsBasedOnCategorySortedByPriceAsc(categoryName:any):Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesorting/${categoryName}`)+"Servicesssss Asc");
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesorting/${categoryName}`);
  }


}
