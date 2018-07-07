import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {DashboardComponent} from '../dashboard/dashboard.component';
import {SidenavbarComponent} from '../sidenavbar/sidenavbar.component';
import {TopsearchbarComponent} from '../topsearchbar/topsearchbar.component';
import {CreatepostComponent} from '../createpost/createpost.component';

const routes: Routes = [
  {path: 'createpost', component: CreatepostComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
