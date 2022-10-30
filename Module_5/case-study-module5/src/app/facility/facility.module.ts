import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacilityRoutingModule } from './facility-routing.module';
import { FacilityListComponent } from './facility-list/facility-list.component';
import { FacilityAddComponent } from './facility-add/facility-add.component';
import { FacilityEditComponent } from './facility-edit/facility-edit.component';
import {ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
    declarations: [FacilityListComponent, FacilityAddComponent, FacilityEditComponent],
    exports: [
        FacilityEditComponent
    ],
    imports: [
        CommonModule,
        FacilityRoutingModule,
        ReactiveFormsModule,
        NgxPaginationModule
    ]
})
export class FacilityModule { }
