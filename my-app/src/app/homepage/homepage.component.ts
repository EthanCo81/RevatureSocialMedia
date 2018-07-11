import { Component, OnInit } from '@angular/core';
import { EditProfileComponent } from 'src/app/edit-profile/edit-profile.component';
import { ProfileComponent } from '../profile/profile.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  private static edit: boolean;
  private static profile: boolean;
  private static forum: boolean;
  private curUser: User;

  constructor(private us: UserService,   private router: Router) {
  }

  ngOnInit() {
    this.setToForum();
    this.us.login(null, null).subscribe(x => {this.curUser = x;
      console.log(x);
      });
    }

  public setToProfile() {
    HomepageComponent.edit = false;
    HomepageComponent.forum = false;
    HomepageComponent.profile = true;
  }

  public setToEdit() {
    HomepageComponent.profile = false;
    HomepageComponent.forum = false;
    HomepageComponent.edit = true;
  }

  public setToForum() {
    HomepageComponent.edit = false;
    HomepageComponent.profile = false;
    HomepageComponent.forum = true;
  }

  public getEdit(): boolean {
    return HomepageComponent.edit;
  }

  public getProfile(): boolean {
    return HomepageComponent.profile;
  }

  public getForum(): boolean {
    return HomepageComponent.forum;
  }
}
