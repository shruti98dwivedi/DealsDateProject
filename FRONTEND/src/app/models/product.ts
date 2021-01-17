import { ProductCategory } from "./product-category.enum";

export class Product {

    public productId:number;
    public productName:string;
    public productQuantity:number;
    public productPrice:number;
    public productColor:string;
    public productSpecification:string;
    public productCategory:ProductCategory;

}
