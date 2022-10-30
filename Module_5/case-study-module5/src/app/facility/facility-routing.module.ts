import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FacilityListComponent} from "./facility-list/facility-list.component";
import {FacilityEditComponent} from "./facility-edit/facility-edit.component";
import {FacilityAddComponent} from "./facility-add/facility-add.component";


const routes: Routes = [
  {
    path: 'list', component : FacilityListComponent,
  },
  {
    path: 'edit/:id', component : FacilityEditComponent,
  },
  {
    path: 'create', component : FacilityAddComponent,
  },
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
