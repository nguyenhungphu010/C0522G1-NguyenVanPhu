import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerEditComponent} from "./customer-edit/customer-edit.component";
import {CustomerAddComponent} from "./customer-add/customer-add.component";
import {CustomerDeleteComponent} from "./customer-delete/customer-delete.component";


const routes: Routes = [
  {
    path: 'list',
    component: CustomerListComponent,
  },
  {
    path: 'edit/:id',
    component: CustomerEditComponent,
  },
  {
    path: 'create', component: CustomerAddComponent,
  },
  {
    path: 'delete',
    component: CustomerDeleteComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
