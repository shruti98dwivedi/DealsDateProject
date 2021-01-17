
import { Component, OnInit  } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductlistService } from 'src/app/services/productlist.service';
import { WishlistService } from 'src/app/services/wishlist.service';

import { ToastrService } from 'ngx-toastr';

import { CartService } from 'src/app/services/cart.service';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {


   categoryName:any;
  productList:Product[]=[];
  sortedProductList:Product[]=[];
  product:Product;
  messeage: Object;
  errorinfo: any;
  isFilter:boolean=true;
  //previousId:number;
  //productIdExist:number[];
  //isExist: boolean;

  constructor(private service:ProductlistService,private cartItemService:CartService,
    private wishListService:WishlistService,private route: ActivatedRoute,private toastr:ToastrService) {
      this.route.paramMap.subscribe((params : ParamMap) => {
        let value= params.get('categoryName');
        this.categoryName=value;
       })     
   }

  ngOnInit(): void {
    this.loadProductList();
  }

  //fetching list if products based on categories
  loadProductList(){
    
           if(this.categoryName==='All'){
             this.service.getListOfProducts().subscribe(
               (data) =>{
                 this.productList=data;
               }
             )
           }

           else{
             this.service.getListOfProductsBasedOnCategory(this.categoryName).subscribe(
               (data)=>{
                 this.productList=data;
                 console.log(this.productList)
               }
             )
              }


  }

  //adding to cart
  goToCart(product:Product){

  //  this.previousId=product.productId;

 //   this.productIdExist.push(product.productId);


  if(product.productId===1)
   product.productQuantity=0;
   if(product.productQuantity===0){
     this.toastr.warning('Out Of Stock..!!','OPPPSSSSOS....',{
      timeOut:1000,
      progressBar:true,
      progressAnimation:'increasing',
     })
   }
    else{
      this.toastr.success('Item Added To The Cart Successfully..!!','YEEHHHHHHH..',{
        timeOut:1000,
        progressBar:true,
        progressAnimation:'increasing',
      })
     this.cartItemService.addToCartItem(product.productId,product).subscribe(
       (data)=>{
        this.messeage=data;
       },
       error=>{
        this.errorinfo=error.error();}
     )
//checking for repetition of elements 
    // for (let index = 0; index < this.productIdExist.length; index++){
     //  if(product.productId===this.productIdExist[index]){
      //   this.isExist=true;
      // }
     }
    //}
  }

  //adding to wishlist
  goToWishList(product:Product){
    this.toastr.warning(' ','Item Added To Wishlist Successfully!!',{
      timeOut:1000,
      progressBar:true,
      progressAnimation:'increasing',
    });
  

   this.wishListService.addtoWishlist(product.productId,product).subscribe(
     (data)=>{
       this.messeage=data;
       console.log("DATA   "+this.messeage)

     },
     error=>{
       this.errorinfo=error.error();
       console.log(this.errorinfo)
     }
   )
  }

  //sort in ascending order
  ascendingSort(){
    this.isFilter=false;
    if(this.categoryName==='All'){
      this.service.getListOfSortedProductAsc().subscribe(
        (data)=>{
          this.sortedProductList=data;
          console.log("Ascending order"+this.sortedProductList);
        }
      )
    }

    else{
           this.service.getListOfProductsBasedOnCategorySortedByPriceAsc(this.categoryName).subscribe(
             (data)=>{
               this.sortedProductList=data;
               console.log("categorywise sorting "+this.sortedProductList);
             }
           )



    }
   

  }

  //sort in descending order
  descendingSort(){
    this.isFilter=false;
    if(this.categoryName==='All'){
      this.service.getListOfSortedProductDesc().subscribe(
        (data)=>{
          this.sortedProductList=data;
          console.log("Descending order"+this.sortedProductList)
        }
      )
  
    }

    else{
this.service.getListOfProductsBasedOnCategorySortedByPriceDesc(this.categoryName).subscribe(
  (data)=>{
    this.sortedProductList=data;
    console.log("descending order category"+this.sortedProductList);
  }
)



    }
  
  

    }
    
  
}
