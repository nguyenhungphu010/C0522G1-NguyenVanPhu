import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TestModuleModule} from './test-module/test-module.module';


const routes: Routes = [
  {
    path: 'candidate', loadChildren: () => TestModuleModule,
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
