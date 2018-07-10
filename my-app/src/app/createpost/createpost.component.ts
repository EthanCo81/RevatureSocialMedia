import { Component, OnInit } from '@angular/core';
import { ForumPost } from 'src/app/forum-post';

@Component({
  selector: 'app-createpost',
  templateUrl: './createpost.component.html',
  styleUrls: ['./createpost.component.css']
})
export class CreatepostComponent implements OnInit {

  constructor(
    private forumPost: ForumPost,
    private nameOfPoster: string,
    private datePosted: string,
    private questionTitle: string,
    private relevantLanguages: string,
    private relevantTechnologies: string,
    private description: string,
    private likes: string,
    private comments: string  
  ) { }



  ngOnInit() {

  }

  submitQuestion(): void{
    //create questionService and link with backend DAOs
    //then submit the given fields

  }

}
