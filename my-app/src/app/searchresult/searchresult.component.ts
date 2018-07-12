import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Employee } from '../employee';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-searchresult',
  templateUrl: './searchresult.component.html',
  styleUrls: ['./searchresult.component.css']
})
export class SearchresultComponent implements OnInit {
    public query: string;
    public employees: Employee[];
    public currentEmployee: object;

    constructor(private searchService: SearchService) { }

    showEmployee(item) {
        this.query = item.firstname;
        item.highlight = !item.hightlight;
    }

    moveToProfile(item) {
        this.currentEmployee = item;
    }

    ngOnInit() {
        this.searchService.getAllEmployees().subscribe( employees => this.employees = employees);
        this.query = '';
    }
}
