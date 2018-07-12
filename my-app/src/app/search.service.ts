import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Profile } from './profile';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private appUrl = 'http://localhost:8080/RevatureSocial/search';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }
  employee: Employee;

  setEmployee(emp: Employee) {
    this.employee = emp;
  }

  getAllEmployees(): Observable<Employee[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as Employee[])
    );
  }

  getEmployeeById(id: number): Observable<Employee> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Employee)
    );
  }

  getEmployeesByKeyword(key: string): Observable<Employee[]> {
    const url: string = this.appUrl + '/keyword=' + key;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Employee[])
    );
  }
}
