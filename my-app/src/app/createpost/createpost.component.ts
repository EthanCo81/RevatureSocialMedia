import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-createpost',
  templateUrl: './createpost.component.html',
  styleUrls: ['./createpost.component.css']
})
export class CreatepostComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  submitQuestion(): void{
    //create questionService and link with backend DAOs
    //then submit the given fields
  }

}
