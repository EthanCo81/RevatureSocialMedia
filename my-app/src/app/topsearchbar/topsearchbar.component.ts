import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';

@Component({
  providers: [LoginComponent],
  selector: 'app-topsearchbar',
  templateUrl: './topsearchbar.component.html',
  styleUrls: ['./topsearchbar.component.css']
})
export class TopsearchbarComponent implements OnInit {

  constructor(private lc: LoginComponent) { }

  ngOnInit() {
  }

}
