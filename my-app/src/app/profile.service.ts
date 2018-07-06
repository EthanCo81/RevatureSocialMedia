import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Employee } from './employee';
import { Instructor } from './instructor';
import { Client } from './client';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private appUrl = 'http://localhost:8080/RevatureSocial/profile';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  // getEmp(): Observable<Employee> {
  //   return this.http.get(this.appUrl, { withCredentials: true }).pipe(
  //     map( resp => resp as Employee)
  //   );
  // }

  getEmp(username: string): Observable<Employee> {
    const url: string = this.appUrl + '/' + username;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Employee)
    );
  }
  updateEmp(employee: Employee): Observable<Employee> {
    const body = JSON.stringify(employee);
    if (employee.username) {
      // update a specific employee (put request)
      const url = this.appUrl + '/' + employee.username;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as Employee)
      );
    }
  }

  getIns(username: string): Observable<Instructor> {
    const url: string = this.appUrl + '/' + username;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Instructor)
    );
  }
  updateins(instructor: Instructor): Observable<Instructor> {
    const body = JSON.stringify(instructor);
    if (instructor.username) {
      // update a specific instructor (put request)
      const url = this.appUrl + '/' + instructor.username;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as Instructor)
      );
    }
  }

  getCln(username: string): Observable<Client> {
    const url: string = this.appUrl + '/' + username;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Client)
    );
  }
  updateCln(client: Client): Observable<Client> {
    const body = JSON.stringify(client);
    if (client.username) {
      // update a specific client (put request)
      const url = this.appUrl + '/' + client.username;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as Client)
      );
    }
  }
}
