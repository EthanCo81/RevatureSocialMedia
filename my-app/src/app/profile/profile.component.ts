import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Profile } from 'src/app/profile';
import { Employee } from 'src/app/employee';
import { ProfileService } from 'src/app/profile.service';
import { Instructor } from '../instructor';
import { Client } from 'src/app/client';

import { EmployeeService } from 'src/app/employee.service';
import { InstructorService } from 'src/app/instructor.service';
import { ClientService } from 'src/app/client.service';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() profile: Profile;
  constructor(
    private profileService: ProfileService,
    private employeeService: EmployeeService,
    private instructorService: InstructorService,
    private clientService: ClientService,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {
   }

  employee: Employee;
  instructor: Instructor;
  client: Client;
  ngOnInit() {
    this.client = this.userService.getClient();
    this.employee = this.userService.getEmployee();
    this.instructor = this.userService.getInstructor();
    
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);

    if (id) {
      this.employeeService.getEmp(id).subscribe(
          emp => this.employee = emp);
      this.instructorService.getIns(id).subscribe(
        ins => this.instructor = ins);
      this.clientService.getClnt(id).subscribe(
        clns => this.client = clns);
    }
    
    
    console.log ('Instructor: ' + this.instructor);
    console.log ('Employee: ' + this.employee);
    console.log ('Client: ' + this.client);
  }
  isClient(): boolean {
    return this.userService.isClient();
  }
  isInstructor(): boolean {
    return this.userService.isInstructor();
  }
  isEmployee(): boolean {
    return this.userService.isEmployee();
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
