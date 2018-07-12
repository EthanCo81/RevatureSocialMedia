import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { ProfileComponent } from '../profile/profile.component';
import { EditProfileComponent } from '../edit-profile/edit-profile.component';
import {HomepageComponent} from '../homepage/homepage.component';
import {DashboardComponent} from '../dashboard/dashboard.component';
import {SidenavbarComponent} from '../sidenavbar/sidenavbar.component';
import {TopsearchbarComponent} from '../topsearchbar/topsearchbar.component';
import {CreatepostComponent} from '../createpost/createpost.component';

const routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'profile/:id',
    component: ProfileComponent
  },
  {
    path: 'editprofile',
    component: EditProfileComponent
  },
  {
    path: 'profile/edit/:id',
    component: EditProfileComponent
  },
  {
    path: 'profile/edit',
    component: EditProfileComponent
  },
  {
    path: 'homepage',
    component: HomepageComponent
  },
  {
    path: 'createpost',
    component: CreatepostComponent
  }

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
