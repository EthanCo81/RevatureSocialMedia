import { Component, OnInit } from '@angular/core';
import { ForumpostService } from 'src/app/forumpost.service';

import { ForumPost } from 'src/app/forum-post';
import { Router } from '@angular/router';

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
  constructor(
    private forumpostService: ForumpostService,
    private router: Router
  ) { }

  ngOnInit() {

  }

  submitQuestion(): void{
    this.forumPost = new ForumPost();
    this.forumPost.id = 69;
    this.forumPost.nameOfPoster = "testPoster";
    this.forumPost.datePosted = "testDate";
    this.forumPost.questionTitle = this.questionTitle;
    this.forumPost.relevantLanguages = this.relevantLanguages;
    this.forumPost.relevantTechnologies = this.relevantTechnologies;
    this.forumPost.description = this.description;
    this.forumPost.likes = "testLikes"
    this.forumPost.comments = "testComment";


      this.forumpostService.updateForumPost(this.forumPost).subscribe(

        fp => {

          this.forumPost = fp;

          this.router.navigate(['/homepage']);

        }

      );

      console.log(this.forumPost);

    //create questionService and link with backend DAOs
    //then submit the given fields

}
}
