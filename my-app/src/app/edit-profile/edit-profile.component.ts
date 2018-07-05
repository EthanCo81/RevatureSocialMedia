import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Location } from '@angular/common';
//import { FormGroup, FormControl, Validators } from '@angular/forms';

import { ProfileService } from 'src/app/profile.service';

import { Profile } from 'src/app/profile';
import { Employee } from 'src/app/employee';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  public employee: Employee;

  constructor(
    private profileService: ProfileService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    // TODO replace username with id
    console.log('Hello from edit-profile\'s oninit()');
    const username = this.route.snapshot.paramMap.get('username');
    console.log(username);

    if (username) {
      this.profileService.getEmp(username).subscribe(
        emp => {
          // set current book to the book retrieved.
          this.employee = emp;
        }
      );
    }
  }

  submit(): void {
    this.profileService.updateEmp(this.employee).subscribe(
      emp => {
        this.employee = emp;
        this.router.navigate(['/profile']);
      }
    );
    console.log(this.employee);
  }
}
