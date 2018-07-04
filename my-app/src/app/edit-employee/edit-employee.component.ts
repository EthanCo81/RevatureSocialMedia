import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Location } from '@angular/common';
//import { FormGroup, FormControl, Validators } from '@angular/forms';

import { EmployeeService } from 'src/app/employee.service';

import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  public employee: Employee;

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    //TODO replace username with id
    console.log("Hello from edit-book's oninit()")
    const username = this.route.snapshot.paramMap.get('username');
    console.log(username);

    if (username) {
      this.employeeService.getEmp(username).subscribe(
        emp => {
          // set current book to the book retrieved.
          this.employee = emp;
          
        }
      );
    }
  }

  submit(): void {
    this.employeeService.updateEmp(this.employee).subscribe(
      emp => {
        this.employee = emp;
        this.router.navigate(['/employee']);
      }
    );
    console.log(this.employee);
  }

}
