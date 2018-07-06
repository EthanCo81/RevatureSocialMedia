import { Component, OnInit, Injectable } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { User } from 'src/app/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  private username: string;
  private password: string;
  private loggedUser: User;
  constructor(
    private userService: UserService,
    private router: Router
  ) { }


  ngOnInit() {
  }

  login(): void {
    this.userService.login(this.username, this.password).subscribe(user => {this.loggedUser = user; });
  }

  getLoggedUser(): User {
    return this.loggedUser;
  }

}
