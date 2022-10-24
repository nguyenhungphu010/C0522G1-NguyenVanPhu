import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacilityRoutingModule } from './facility-routing.module';
import { FacilityListComponent } from './facility-list/facility-list.component';
import { FacilityAddComponent } from './facility-add/facility-add.component';
import { FacilityEditComponent } from './facility-edit/facility-edit.component';


@NgModule({
  declarations: [FacilityListComponent, FacilityAddComponent, FacilityEditComponent],
  imports: [
    CommonModule,
    FacilityRoutingModule
  ]
})
export class FacilityModule { }
