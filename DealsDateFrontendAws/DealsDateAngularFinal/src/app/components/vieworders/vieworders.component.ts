import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from 'src/app/models/order';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-vieworders',
  templateUrl: './vieworders.component.html',
  styleUrls: ['./vieworders.component.css']
})
export class ViewordersComponent implements OnInit {

  orders:Observable<Order[]>;



  constructor(private __service:AdminService) {
   }

  ngOnInit(): void {
    this.reloadData();    
  }

  reloadData() {
    this.orders = this.__service.fetchAllOrder();
  }
  deleteOrder(orderId: number) {
    this.__service.deleteOrderById(orderId)
      .subscribe(
        data => {
          console.log(data);
          alert('Order deleted');
          this.reloadData();
        },
        error => console.log(error));
  }


}
