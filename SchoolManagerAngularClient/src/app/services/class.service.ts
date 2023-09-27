import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Class } from '../model/class';

@Injectable({
  providedIn: 'root'
})
export class ClassService {

  constructor(private http: HttpClient) { }

  create(aClass: Class) {
    return this.http.post("/api/class", aClass);
  }

  edit(aClass: Class) {
    return this.http.put("/api/class/" + aClass.id, aClass);
  }

  delete(id: number) {
    return this.http.delete("/api/class/" + id);
  }

  findAll(): Observable<Class[]> {
    return this.http.get<Class[]>("/api/class/all");
  }

  findById(id: any): Observable<any> {
    return this.http.get("/api/class/" + id);
  }

  report(): Observable<any> {
    return this.http.get<any>("/api/report/class");
  }

}
