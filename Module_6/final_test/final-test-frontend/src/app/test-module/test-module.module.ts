import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TestModuleRoutingModule } from './test-module-routing.module';

import { CandidateListComponent } from './candidate-list/candidate-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [ CandidateListComponent],
  imports: [
    CommonModule,
    TestModuleRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgbPaginationModule,
  ]
})
export class TestModuleModule { }
