import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdmincontrolComponent } from './components/actors/admincontrol/admincontrol.component';
import { UserComponent } from './components/actors/user/user.component';
import { AdminComponent } from './components/authorization/admin/admin.component';
import { LoginComponent } from './components/authorization/login/login.component';
import { SignupComponent } from './components/authorization/signup/signup.component';
import { CartComponent } from './components/cart/cart.component';
import { FilterProductsComponent } from './components/filter-products/filter-products.component';
import { HomeComponent } from './components/home/home.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { AboutusComponent } from './components/shared/aboutus/aboutus.component';

import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import { ViewordersComponent } from './components/vieworders/vieworders.component';
import { WishlistComponent } from './components/wishlist/wishlist.component';


const routes: Routes = [
  { path: '', redirectTo:'/home',pathMatch:'full' },
  { path: 'home', component: HomeComponent,pathMatch:"full"},
  { path: 'aboutUs', component: AboutusComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'admincontroller', component: AdmincontrolComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'shoppingcart', component: ShoppingCartComponent },
  { path: 'productlist/:categoryName', component: ProductListComponent },
  { path: 'filter', component:FilterProductsComponent },
  { path: 'wishlist', component:WishlistComponent },
  { path: 'userprofile', component:UserComponent },
  { path: 'cart', component:CartComponent },
  { path: 'vieworder', component:ViewordersComponent  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, AdminComponent, AdmincontrolComponent,ViewordersComponent ,
  CartComponent,WishlistComponent,UserComponent,FilterProductsComponent,
  AboutusComponent,LoginComponent,SignupComponent,ShoppingCartComponent,ProductListComponent]
