import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ObjectListComponent} from './object-list/object-list.component';
import {ObjectEditComponent} from './object-edit/object-edit.component';
import {BodyComponent} from '../body/body.component';


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
    path: 'create', component: ObjectEditComponent,
  },
  {
    path: '', component: BodyComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ObjectTestRoutingModule {
}
