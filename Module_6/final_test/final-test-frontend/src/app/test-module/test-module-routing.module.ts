import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CandidateListComponent} from './candidate-list/candidate-list.component';


const routes: Routes = [{
  path: 'list', component: CandidateListComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TestModuleRoutingModule {
}
