import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ListStudent } from '../model/listStudent';
import { Student } from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  create(student: Student) {
    return this.http.post("/api/student", student);
  }

  edit(student: Student) {
    return this.http.put("/api/student/" + student.id, student);
  }

  delete(id: number) {
    return this.http.delete("/api/student/" + id);
  }

  findAll(): Observable<ListStudent[]> {
    return this.http.get<ListStudent[]>("/api/student/list");
  }

  findById(id: any): Observable<any> {
    return this.http.get("/api/student/" + id);
  }

  report(): Observable<any> {
    return this.http.get<any>("/api/report/student");
  }

}
