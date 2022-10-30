import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ObjectTestModule} from './object-test/object-test.module';


const routes: Routes = [
  {
    path: 'object',
    loadChildren: () => ObjectTestModule,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
