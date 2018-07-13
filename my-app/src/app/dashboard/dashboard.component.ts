import { Component, OnInit } from '@angular/core';
import { ForumPost } from '../forum-post';
// import { ForumpostComponent } from 'src/app/forumpost/forumpost.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  providers: []
})
export class DashboardComponent implements OnInit {
  forums: Array<ForumPost>;
  constructor() {}

  ngOnInit() {
  }



}
