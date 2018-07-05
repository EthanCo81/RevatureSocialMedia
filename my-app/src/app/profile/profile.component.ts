import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Profile } from 'src/app/profile';
import { Employee } from 'src/app/employee';
import { ProfileService } from '../profile.service';
import { Instructor } from '../instructor';
import { Client } from 'src/app/client';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  @Input() profile: Profile;
  constructor(
    private profileService: ProfileService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) {
    
   }

  employee: Employee;
  instructor: Instructor;
  client: Client;
  ngOnInit() {
    //TODO: Change to recognize what type of person is logged in (employee, instructor, or client)
    const username = this.route.snapshot.paramMap.get('username');

    /*if (username) {
      this.profileService.getEmp(username).subscribe(
          emp => this.employee = emp);
    }*/
  }

  
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
    // this.router.navigate('/profile/edit/' + this.employee.id);
    this.router.navigate(['/profile/edit', this.employee.id]);
  }

  editIns(): void {
    // this.router.navigate('/profile/edit/' + this.instructor.id);
    this.router.navigate(['/profile/edit', this.instructor.id]);
  }

  editCln(): void {
    // this.router.navigate('/profile/edit/' + this.client.id);
    this.router.navigate(['/profile/edit', this.client.id]);
  }

}
