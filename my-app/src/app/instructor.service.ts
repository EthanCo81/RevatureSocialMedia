import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Profile } from './profile';
import { Instructor } from './instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  //Might change this to just profile later
  private appUrl = 'http://localhost:8080/RevatureSocial/instructor_profile';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  getInsts(): Observable<Instructor[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as Instructor[])
    );
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
}
