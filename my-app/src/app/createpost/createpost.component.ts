import { Component, OnInit } from '@angular/core';
import { ForumpostService } from 'src/app/forumpost.service';

import { ForumPost } from 'src/app/forum-post';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-createpost',
  templateUrl: './createpost.component.html',
  styleUrls: ['./createpost.component.css']
})
export class CreatepostComponent implements OnInit {
  public forumPost: ForumPost;
  private id: number;
  private nameOfPoster: string;
  private datePosted: string;
  private questionTitle: string;
  private relevantLanguages: string;
  private relevantTechnologies: string;
  private description: string;
  private likes: string;
  private comments: string;
  private user: User;

  constructor(
    private forumpostService: ForumpostService,
    private router: Router,
    private us: UserService
  ) { }

  ngOnInit() {
    this.user = this.us.isEmployee() ? UserService.employee : this.us.isClient ? UserService.client : UserService.instructor;
  }

  submitQuestion(): void {
    this.forumPost = new ForumPost();
    this.forumPost.nameOfPoster = this.user.firstname + ' ' + this.user.lastname;
    this.forumPost.datePosted = 'null';
    this.forumPost.questionTitle = this.questionTitle;
    this.forumPost.relevantLanguages = this.relevantLanguages;
    this.forumPost.relevantTechnologies = this.relevantTechnologies;
    this.forumPost.questionAsked = this.description;


      this.forumpostService.createForumPost(this.forumPost).subscribe(

        fp => {

          this.forumPost = fp;

          this.router.navigate(['/homepage']);

        }

      );

      console.log(this.forumPost);

    // create questionService and link with backend DAOs
    // then submit the given fields

}
}
