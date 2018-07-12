import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Profile } from '../profile';
import { Employee } from '../employee';
import { ProfileService } from '../profile.service';
import { Instructor } from '../instructor';
import { Client } from '../client';

import { EmployeeService } from '../employee.service';
import { InstructorService } from '../instructor.service';
import { ClientService } from '../client.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() profile: Profile;
  constructor(
    private ps: ProfileService,
    // private employeeService: EmployeeService,
    // private instructorService: InstructorService,
    // private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {
   }

  employee: Employee;
  instructor: Instructor;
  client: Client;
  ngOnInit() {
    // TODO: Change to recognize what type of person is logged in (employee, instructor, or client)
    const id = +this.route.snapshot.paramMap.get('id');
    this.ps.setUser();
    if (this.isClient()) {
      this.client = this.ps.userService.getClient();
    } else if (this.isEmployee()) {
      this.employee = this.ps.userService.getEmployee();
    } else if (this.isInstructor()) {
      this.instructor = this.ps.userService.getInstructor();
    }
    console.log ('Instructor: ' + this.instructor);
    console.log ('Employee: ' + this.employee);
    console.log ('Client: ' + this.client);
  }
  isClient(): boolean {
    return this.ps.isClient();
  }
  isInstructor(): boolean {
    return this.ps.isInstructor();
  }
  isEmployee(): boolean {
    return this.ps.isEmployee();
  }

  editEmp(): void {
    this.router.navigate(['/profile/edit', this.employee.id]);
  }

  editIns(): void {
    this.router.navigate(['/profile/edit', this.instructor.id]);
  }

  editCln(): void {
    this.router.navigate(['/profile/edit', this.client.id]);
  }

}
