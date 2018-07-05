import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Profile } from './profile';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  //Might change this to just profile later
  private appUrl = 'http://localhost:8080/RevatureSocial/employee_profile';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  getEmps(): Observable<Employee[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as Employee[])
    );
  }

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
}
