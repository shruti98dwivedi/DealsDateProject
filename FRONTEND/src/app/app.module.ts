import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule , routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { NavComponent } from './components/shared/nav/nav.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FiltersComponent } from './components/shopping-cart/filters/filters.component';

import { ToastrModule } from 'ngx-toastr';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
//import { MatDialog,MatDialogRef ,MAT_DIALOG_DATA } from '@angular/material/dialog';
//import {MatDialogModule} from '@angular/material/dialog';
import {MatRadioModule} from '@angular/material/radio';


import { WishlistComponent } from './components/wishlist/wishlist.component';
import { OrderComponent } from './components/order/order.component';

import { UserComponent } from './components/actors/user/user.component';
import { CartComponent } from './components/cart/cart.component';

import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductlistService } from './services/productlist.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FilterProductsComponent } from './components/filter-products/filter-products.component';
import { WishlistService } from './services/wishlist.service';
import { UserService } from './services/user.service';
import { AdmincontrolComponent } from './components/actors/admincontrol/admincontrol.component';
import { AdminComponent } from './components/authorization/admin/admin.component';
import { ViewordersComponent } from './components/vieworders/vieworders.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    ShoppingCartComponent,
    FiltersComponent,
    CartComponent,
    
    ProductListComponent,
   routingComponents,
   WishlistComponent,
   OrderComponent,
   
   UserComponent,
   FilterProductsComponent,
   AdmincontrolComponent,
   AdminComponent,
   ViewordersComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatRadioModule,
   // MatDialogModule,
   ToastrModule.forRoot(),
    FormsModule,
    MatIconModule,
    HttpClientModule,
    MatSelectModule,
    MatButtonModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [ProductlistService,WishlistService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
