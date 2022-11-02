import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ObjectListComponent} from './object-list/object-list.component';
import {ObjectEditComponent} from './object-edit/object-edit.component';
import {ObjectCreateComponent} from './object-create/object-create.component';


const routes: Routes = [
  {
    path: 'list',
    component: ObjectListComponent,
  },
  {
    path: 'edit/:id',
    component: ObjectEditComponent,
  },
  {
    path: 'create', component: ObjectCreateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ObjectTestRoutingModule {
}
