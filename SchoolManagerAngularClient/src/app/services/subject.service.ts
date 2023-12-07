import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subject } from '../model/subject';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  constructor(private http: HttpClient) { }

  list(): Observable<Subject[]> {
    return this.http.get<Subject[]>("/api/subject");
  }

  create(subject: Subject): Observable<Subject[]> {
    return this.http.post<Subject[]>("/api/subject", subject);
  }

  delete(id: number): Observable<Subject[]> {
    return this.http.delete<Subject[]>("/api/subject/" + id);
  }

}
