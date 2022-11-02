import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ObjectTestModule} from './object-test/object-test.module';
import {BodyComponent} from './body/body.component';


const routes: Routes = [
  {
    path: 'object',
    loadChildren: () => ObjectTestModule,
  }
  ,
  {
    path: '', component: BodyComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
