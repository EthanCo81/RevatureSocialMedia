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

  instructor: Instructor;

  setInstructor(inst: Instructor){
    this.instructor = inst;
  }

  getInsts(): Observable<Instructor[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as Instructor[])
    );
  }

  getIns(id: number): Observable<Instructor> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Instructor)
    );
  }

  updateins(instructor: Instructor): Observable<Instructor> {
    const body = JSON.stringify(instructor);
    if (instructor.id) {
      // update a specific instructor (put request)
      const url = this.appUrl + '/' + instructor.id;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as Instructor)
      );
    }
  }

  getInstructor(): Instructor {
    return this.instructor;
  }
  isInstructor() {
    return (this.instructor !== undefined && this.instructor !== null);
  }
}
