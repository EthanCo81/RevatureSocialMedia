import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from './user';
import { Instructor } from './instructor';
import { Employee } from './employee';
import { Client } from './client';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = 'http://localhost:8080/RevatureSocialMedia/login';
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
  private employee: Employee;
  private instructor: Instructor;
  private client: Client;

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    if (username && password) {
      // we need to log in
      console.log(username);
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
        map(
          resp => {
            const user: User = resp as User;
            console.log(user);
            if (user instanceof Employee) {
              this.employee = user;
            }
            if (user instanceof Instructor) {
              this.instructor = user;
            }
            if (user instanceof Client) {
              this.client = user;
            }
            return user;
          }
        )
      );
    } else {
      // we are just checking to see if we're already logged in
      return this.http.get(this.appUrl, { withCredentials: true })
        .pipe(map(
          resp => {
            const user: User = resp as User;
            if (user instanceof Employee) {
              this.employee = user;
            }
            if (user instanceof Instructor) {
              this.instructor = user;
            }
            if (user instanceof Client) {
              this.client = user;
            }
            return user;
          }
        ));
    }
  }
  logout(): Observable<Object> {
    return this.http.delete(this.appUrl, { withCredentials: true }).pipe(
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
