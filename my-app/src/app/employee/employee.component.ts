import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Employee } from 'src/app/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  @Input() employee: Employee;
  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {
    
   }

  ngOnInit() {
    //TODO: Change to id later
    const username = this.route.snapshot.paramMap.get('username');

    if (username) {
      this.employeeService.getEmp(username).subscribe(
          emp => this.employee = emp);
    }
  }

  //May not need these?
  // isClient(): boolean{
  //   return this.userService.isClient();
  // }
  // isInstructor(): boolean {
  //   return this.userService.isInstructor();
  // }
  // isEmployee(): boolean {
  //   return this.userService.isEmployee();
  // }

  editEmp(): void {
    // this.router.navigate('/employee/edit/' + this.employee.id);
    this.router.navigate(['/employee/edit', this.employee.username]);
  }

}
