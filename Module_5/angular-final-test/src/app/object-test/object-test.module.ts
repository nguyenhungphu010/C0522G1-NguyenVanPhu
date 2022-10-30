import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ObjectTestRoutingModule } from './object-test-routing.module';
import { ObjectListComponent } from './object-list/object-list.component';
import { ObjectEditComponent } from './object-edit/object-edit.component';
import { ObjectCreateComponent } from './object-create/object-create.component';


@NgModule({
  declarations: [ObjectListComponent, ObjectEditComponent, ObjectCreateComponent],
  imports: [
    CommonModule,
    ObjectTestRoutingModule
  ]
})
export class ObjectTestModule { }
