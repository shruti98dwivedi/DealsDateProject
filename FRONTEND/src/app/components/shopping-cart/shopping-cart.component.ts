import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  categoryName:any;
  value:any;

  constructor(private route :ActivatedRoute,private router : Router) { 
   /* this.route.paramMap.subscribe((params : ParamMap) => {
      let value= params.get('categoryName');
      this.categoryName=value;
     })*/
     
  }

  ngOnInit(): void {

    
    //console.log(this.categoryName+"Shopping cart ngonit")
  }
 
}
