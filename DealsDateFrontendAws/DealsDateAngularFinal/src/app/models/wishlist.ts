import { ProductCategory } from "./product-category.enum";

export class Wishlist {

    wishlistId:number;
    productId:number;
    productName:string;
    productPrice:number;
    productColor:string;
    productSpecification:string;
    productCategory:ProductCategory;
    imageUrl:string;
}
