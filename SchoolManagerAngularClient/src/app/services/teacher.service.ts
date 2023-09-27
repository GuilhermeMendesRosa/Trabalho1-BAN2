import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Teacher } from '../model/teacher';
import { Observable } from 'rxjs';
import { ListTeacher } from '../model/listTeacher';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  constructor(private http: HttpClient) { }

  create(teacher: Teacher) {
    return this.http.post("/api/teacher", teacher);
  }

  edit(teacher: Teacher) {
    return this.http.put("/api/teacher/" + teacher.id, teacher);
  }

  delete(id: number) {
    return this.http.delete("/api/teacher/" + id);
  }

  listNoManaging(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>("/api/teacher/no-managing");
  }

  listAll(): Observable<ListTeacher[]> {
    return this.http.get<ListTeacher[]>("/api/teacher/list");
  }

  findById(id: any): Observable<ListTeacher> {
    return this.http.get<ListTeacher>("/api/teacher/" + id);
  }

  report(): Observable<any> {
    return this.http.get<any>("/api/report/teacher");
  }

}
