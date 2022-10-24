import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractRoutingModule } from './contract-routing.module';
import { ContractListComponent } from './contract-list/contract-list.component';
import { ContractAddComponent } from './contract-add/contract-add.component';


@NgModule({
  declarations: [ContractListComponent, ContractAddComponent],
  imports: [
    CommonModule,
    ContractRoutingModule
  ]
})
export class ContractModule { }
