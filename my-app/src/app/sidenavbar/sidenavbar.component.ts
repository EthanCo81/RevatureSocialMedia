import { Component, OnInit } from '@angular/core';
import { HomepageComponent } from 'src/app/homepage/homepage.component';

@Component({
  providers: [HomepageComponent],
  selector: 'app-sidenavbar',
  templateUrl: './sidenavbar.component.html',
  styleUrls: ['./sidenavbar.component.css']
})
export class SidenavbarComponent implements OnInit {

  constructor(private hp: HomepageComponent) { }

  ngOnInit() {
  }

}
