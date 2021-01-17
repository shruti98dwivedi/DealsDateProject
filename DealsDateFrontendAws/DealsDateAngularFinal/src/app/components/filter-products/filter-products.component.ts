import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
//import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Product } from 'src/app/models/product';
import { ProductlistService } from 'src/app/services/productlist.service';

@Component({
  selector: 'app-filter-products',
  templateUrl: './filter-products.component.html',
  styleUrls: ['./filter-products.component.css']
})
export class FilterProductsComponent implements OnInit {

  type:any;
  list:Product[]
  dialogId: any;

  constructor(private service:ProductlistService){ }

  ngOnInit(): void {
     
  }

  /*onClicking(){

    if(this.type==="Low To High"){
    this.service.getListOfSortedProductAsc().subscribe(
      (data)=>{
this.list=data;
      }
    )}

    else{

      this.service.getListOfSortedProductDesc().subscribe(
        (data)=>{
  this.list=data;
        }
      )
    }
    
  }*/



 /* onNoClick() :void{
    this.dialogRef.close();
  }

  onOkClick(){
    this.onClicking();
    this.dialogRef.close({data:this.list});
  }*/
}
