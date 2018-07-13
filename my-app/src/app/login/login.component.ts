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
  private static loggedUser: User;
  private username: string;
  private password: string;
  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  logout(): void {
    this.userService.logout().subscribe();
    LoginComponent.loggedUser = null;
    this.username = null;
    this.password = null;
    this.router.navigate(['./login']);
  }
  ngOnInit() {
  }

  login(): void {
    this.userService.login(this.username, this.password).subscribe(x => {LoginComponent.loggedUser = x;
    console.log(x);
    if (LoginComponent.loggedUser !== undefined) {
      this.router.navigate(['./homepage']);
    } else {
      this.router.navigate(['./login']);
    }});
    console.log(LoginComponent.loggedUser);
  }




}
