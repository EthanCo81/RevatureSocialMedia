import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ProfileService } from '../profile.service';

import { Profile } from '../profile';
import { Employee } from '../employee';
import { Instructor } from '../instructor';
import { Client } from '../client';

import { EmployeeService } from '../employee.service';
import { InstructorService } from '../instructor.service';
import { ClientService } from '../client.service';
import { UserService } from '../user.service';

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

    public id: number;
  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    console.log(this.id);


    this.client = this.userService.getClient();
    this.employee = this.userService.getEmployee();
    this.instructor = this.userService.getInstructor();

    //Uncomment this to view/test updating if login is not persisting.
    /*if (this.id) {
      this.employeeService.getEmp(this.id).subscribe(
          emp => this.employee = emp);
      this.instructorService.getIns(this.id).subscribe(
        ins => this.instructor = ins);
      this.clientService.getClnt(this.id).subscribe(
        clns => this.client = clns);
    }*/
    
  }

  submit(): void {
    //NOTE: Until login persists, this if statement will fail.
    if (this.profileService.isEmployee()) {
      this.employeeService.updateEmp(this.employee).subscribe(
        emp => {
          this.employee = emp;
          this.router.navigate(['/profile']);
        }
      );
      console.log(this.employee);
    }

    //NOTE: Until login persists, this if statement will fail.
    if (this.profileService.isInstructor()) {
      this.instructorService.updateins(this.instructor).subscribe(
        ins => {
          this.instructor = ins;
          this.router.navigate(['/profile']);
        }
      );
      console.log(this.instructor);
    }

    //NOTE: Until login persists, this if statement will fail.
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
