import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Profile } from './profile';
import { Client } from './client';

@Injectable({
  providedIn: 'root'
})

export class ClientService {
  //Might change this to just profile later
  private appUrl = 'http://localhost:8080/RevatureSocial/client_profile';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  getClns(): Observable<Client[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as Client[])
    );
  }

  getClnt(id: number): Observable<Client> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Client)
    );
  }

  updateClnt(client: Client): Observable<Client> {
    const body = JSON.stringify(client);
    if (client.id) {
      // update a specific client (put request)
      const url = this.appUrl + '/' + client.id;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as Client)
      );
    }
  }

  // getClient(): Client {
  //   return this.client;
  // }
  // isClient() {
  //   return (this.client !== undefined && this.client !== null);
  // }
}
