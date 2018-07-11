import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from './user';
import { Instructor } from './instructor';
import { Employee } from './employee';
import { Client } from './client';
import { CurrentUser } from './current-user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = 'http://localhost:8080/RevatureSocial/';
  private employee: Employee;
  private instructor: Instructor;
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private client: Client;

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string): Observable<User> {
    if (username && password) {
      // we need to log in
      console.log(username);

      const trial =  new User;
      trial.username = username;
      trial.password = password;
      console.log(trial);
      const myJSON = JSON.stringify(trial);
      console.log(myJSON);
      return this.http.post(this.appUrl + 'login', myJSON, { headers: this.headers, withCredentials: true }).pipe(
        map(
          resp => {
            const user: CurrentUser = resp as CurrentUser;
            console.log(user);
            this.employee = user.employee;
            this.client = user.client;
            this.instructor = user.instructor;
            console.log(this);
            return ( this.employee !== undefined) ? this.employee :
            (this.client !== undefined)
             ? this.client : this.instructor;
          }
        )
      );
    } else {
      // we are just checking to see if we're already logged in
      return this.http.get(this.appUrl + 'login', { withCredentials: true })
        .pipe(map(
          resp => {
            const user: CurrentUser = resp as CurrentUser;
            console.log('User: ' + user);
            if (user) {
              this.employee = user.employee;
              console.log ('Users Employee: ' + user.employee);
              this.client = user.client;
              this.instructor = user.instructor;
            }
            return (this.employee != null) ? this.employee : (this.client != null) ? this.client : this.instructor;
          }
        ));
    }
  }
  logout(): Observable<Object> {
    return this.http.delete(this.appUrl + 'login', { withCredentials: true }).pipe(
      map(success => {
        this.employee = null;
        this.client = null;
        this.instructor = null;
        return success;
      })
    );
  }


  getInstructor(): Instructor {
    return this.instructor;
  }
  getEmployee(): Employee {
    return this.employee;
  }
  getClient(): Client {
    return this.client;
  }
  isEmployee() {
    return (this.employee !== undefined && this.employee !== null);
  }
  isInstructor() {
    return (this.instructor !== undefined && this.instructor !== null);
  }
  isClient() {
    return (this.client !== undefined && this.client !== null);
  }
}
