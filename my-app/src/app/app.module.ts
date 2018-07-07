import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SidenavbarComponent } from './sidenavbar/sidenavbar.component';
import { TopsearchbarComponent } from './topsearchbar/topsearchbar.component';
//import { AppRoutingModule } from './/app-routing.module';
import { ForumpostComponent } from './forumpost/forumpost.component';
import { CreatepostComponent } from './createpost/createpost.component';
import { AppRoutingModule } from './app-routing/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SidenavbarComponent,
    TopsearchbarComponent,
    ForumpostComponent,
    CreatepostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
