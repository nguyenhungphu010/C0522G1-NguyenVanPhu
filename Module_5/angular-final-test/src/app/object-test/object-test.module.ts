import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ObjectTestRoutingModule } from './object-test-routing.module';
import { ObjectListComponent } from './object-list/object-list.component';
import { ObjectEditComponent } from './object-edit/object-edit.component';
import { ObjectCreateComponent } from './object-create/object-create.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [ObjectListComponent, ObjectEditComponent, ObjectCreateComponent],
    imports: [
        CommonModule,
        ObjectTestRoutingModule,
        NgxPaginationModule,
        ReactiveFormsModule,
        FormsModule
    ]
})
export class ObjectTestModule { }
