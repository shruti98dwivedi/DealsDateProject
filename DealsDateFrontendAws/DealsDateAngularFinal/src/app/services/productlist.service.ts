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
  //this.baseUrl='http://localhost:8084/home'
  this.baseUrl='http://18.219.166.133:8080/product/home'
 //this.baseUrl='http://localhost:8002/home'
   }

   getCategoryList():Observable<String[]>{
   // return this.httpClient.get<String[]>(`${this.baseUrl}/listofcategories`);
    return this.httpClient.get<String[]>(`${this.baseUrl}/listofcategories`);
   }

  getListOfProducts():Observable<Product[]>{
    
    //return this.httpClient.get<Product[]>(`${this.baseUrl}/displaylistofproducts`);
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproducts`);
  }

  getListOfProductsBasedOnCategory(categoryName:any):Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>(`${this.baseUrl}/fetchlistofproductsbycategory/${categoryName}`)+"Servicesssss");
   // return this.httpClient.get<Product[]>(`${this.baseUrl}/fetchlistofproductsbycategory/${categoryName}`);
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofspecificproducts/${categoryName}`);
  }

  getListOfSortedProductAsc():Observable<Product[]>{
   // return this.httpClient.get<Product[]>(`${this.baseUrl}/listofsortedproductsasc`);
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductsinasc`);
  }

  getListOfSortedProductDesc():Observable<Product[]>{
   // return this.httpClient.get<Product[]>(`${this.baseUrl}/listofsortedproductsdesc`);
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductsindesc`);
  }

  

  getListOfProductsBasedOnCategorySortedByPriceDesc(categoryName:any):Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesortingdesc/${categoryName}`)+"Servicesssss Desc");
   // return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesortingdesc/${categoryName}`);
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesortingdesc/${categoryName}`);
  }

  getListOfProductsBasedOnCategorySortedByPriceAsc(categoryName:any):Observable<Product[]>{
    console.log(this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesorting/${categoryName}`)+"Servicesssss Asc");
   // return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesorting/${categoryName}`);
    return this.httpClient.get<Product[]>(`${this.baseUrl}/listofproductscategorywisesorting/${categoryName}`);
  }


}
