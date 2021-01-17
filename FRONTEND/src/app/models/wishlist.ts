import { ProductCategory } from "./product-category.enum";

export class Wishlist {

    wishlistId:number;
    productId:number;
    productName:string;
    price:any;
    productColor:string;
    productDescription:string;
    productCategory:ProductCategory;
    imageUerl:string;
}
