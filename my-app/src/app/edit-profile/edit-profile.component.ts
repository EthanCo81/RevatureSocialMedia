import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ProfileService } from 'src/app/profile.service';

import { Profile } from 'src/app/profile';
import { Employee } from 'src/app/employee';
import { Instructor } from 'src/app/instructor';
import { Client } from 'src/app/client';

import { EmployeeService } from 'src/app/employee.service';
import { InstructorService } from 'src/app/instructor.service';
import { ClientService } from 'src/app/client.service';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  constructor(
    private profileService: ProfileService,
    private employeeService: EmployeeService,
    private instructorService: InstructorService,
    private clientService: ClientService,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) { }

    public employee: Employee;
    public instructor: Instructor;
    public client: Client;

  ngOnInit(): void {
    
    console.log("Hello from edit-profile's oninit()")
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);

    

    this.client = this.userService.getClient();
    this.employee = this.userService.getEmployee();
    this.instructor = this.userService.getInstructor();

    // this.employee = new Employee();
    // this.employee.firstname = "Harry";
    // this.employee.username = "hsmith";
    // this.employee.lastname = "Smith";
    // this.employee.id = 2521;
    // this.employee.password = "pass";

    if (this.profileService.isEmployee()) {
      this.employeeService.getEmp(id).subscribe(
        emp => {
          // set current employee to the emp retrieved.
          this.employee = emp;
        }
      );
    }

    // if (this.profileService.isInstructor()) {
    //   this.instructorService.getIns(id).subscribe(
    //     ins => {
    //       // set current employee to the emp retrieved.
    //       this.instructor = ins;
    //     }
    //   );
    // }

    if (this.profileService.isClient()) {
      this.clientService.getClnt(id).subscribe(
        cln => {
          // set current employee to the emp retrieved.
          this.client = cln;
        }
      );
    }
  }

  submit(): void {
    if (this.profileService.isEmployee()) {
      this.employeeService.updateEmp(this.employee).subscribe(
        emp => {
          this.employee = emp;
          this.router.navigate(['/profile']);
        }
      );
      console.log(this.employee);
    }

    if (this.profileService.isInstructor()) {
      this.instructorService.updateins(this.instructor).subscribe(
        ins => {
          this.instructor = ins;
          this.router.navigate(['/profile']);
        }
      );
      console.log(this.instructor);
    }

    if (this.profileService.isClient()) {
      this.clientService.updateClnt(this.client).subscribe(
        cln => {
          this.client = cln;
          this.router.navigate(['/profile']);
        }
      );
      console.log(this.client);
    }
  }

}
