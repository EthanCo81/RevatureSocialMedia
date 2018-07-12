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
    public employees: Employee[];

    constructor(private searchService: SearchService) { }

    showEmployee(item) {
        this.query = item.firstname;
        item.highlight = !item.hightlight;
    }

    moveToProfile(item) {
        window.location.assign('/profile/' + item.id);
    }

    ngOnInit() {
        this.searchService.getAllEmployees().subscribe( employees => this.employees = employees);
        this.query = '';
    }
}
