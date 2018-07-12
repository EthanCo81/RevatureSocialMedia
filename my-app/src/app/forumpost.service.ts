import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { ForumPost } from './forum-post';

@Injectable({
  providedIn: 'root'
})
export class ForumpostService {
  
  private appUrl = 'http://localhost:8080/RevatureSocial/createpost';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }
  
  getForumPosts(): Observable<ForumPost[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as ForumPost[])
    );
  }
  getForumPost(id: number): Observable<ForumPost> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as ForumPost)
    );
  }
  updateForumPost(forumPost: ForumPost): Observable<ForumPost> {
    const body = JSON.stringify(forumPost);
    if (forumPost.id) {
      // update a specific post (put request)
      const url = this.appUrl + '/' + forumPost.id;
      return this.http.put(url, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as ForumPost)
      );
    } 
  }
  createForumPost(forumPost: ForumPost): Observable<ForumPost> {
    // create a new forumpost (post)
    const body = JSON.stringify(forumPost);
    const url = this.appUrl + '/' + forumPost.id;
    return this.http.post(url, body,
      { headers: this.headers, withCredentials: true }).pipe(
        map(resp => resp as ForumPost)
      );
  }
}