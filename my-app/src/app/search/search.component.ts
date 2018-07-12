import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Employee } from '../employee';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
    public query: string;
    public selected: string;
    public employees: Employee[];

    constructor(private searchService: SearchService) { }

    selectEmployee(item) {
        this.selected = item.username;
    }

    moveToProfile(item) {
        window.location.assign('/profile/' + item.id);
    }

    updateQuery(item) {
        this.query = item;
        this.searchService.getEmployeesByKeyword(item).subscribe( employees => this.employees = employees);
    }

    ngOnInit() {
        this.query = '';
    }
}
