import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Employee } from './employee';
import { Instructor } from './instructor';
import { Client } from './client';

import { EmployeeService } from './employee.service';
import { InstructorService } from './instructor.service';
import { ClientService } from './client.service';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private appUrl = 'http://localhost:8080/RevatureSocial/profile';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});



  constructor(
    private http: HttpClient,
    private employeeService: EmployeeService,
    private instructorService: InstructorService,
    private clientService: ClientService,
    public userService: UserService
  ) { }

  setUser() {
    console.log(this.userService.loginCheck());
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

  isInstructor(): boolean {
    return this.userService.isInstructor();
  }

  isClient(): boolean {
    return this.userService.isClient();
  }
}
