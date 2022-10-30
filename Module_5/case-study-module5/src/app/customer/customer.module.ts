import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CustomerRoutingModule} from './customer-routing.module';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerAddComponent} from './customer-add/customer-add.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {CustomerService} from "../service/customer.service";
import { CustomerDeleteComponent } from './customer-delete/customer-delete.component';
import {ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [CustomerListComponent, CustomerAddComponent, CustomerEditComponent, CustomerDeleteComponent],
    imports: [
        CommonModule,
        CustomerRoutingModule,
        ReactiveFormsModule,
        NgxPaginationModule,
    ],
  exports: [
    CustomerListComponent
  ],
  providers: [
    CustomerService
  ]
})
export class CustomerModule {
}
