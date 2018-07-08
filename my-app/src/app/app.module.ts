import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'; 

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { ProfileComponent } from './profile/profile.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { CreatepostComponent } from './createpost/createpost.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForumpostComponent } from './forumpost/forumpost.component';
import { SidenavbarComponent } from './sidenavbar/sidenavbar.component';
import { TopsearchbarComponent } from './topsearchbar/topsearchbar.component';
import { HomepageComponent } from './homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    EditProfileComponent,
    CreatepostComponent,
    DashboardComponent,
    ForumpostComponent,
    SidenavbarComponent,
    TopsearchbarComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
