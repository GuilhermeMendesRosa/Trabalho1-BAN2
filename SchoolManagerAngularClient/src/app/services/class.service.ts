import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Class } from '../model/class';
import {CreateSubjectRelationDTO} from "../model/CreateSubjectRelationDTO";

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

  listAll(): Observable<Class[]> {
    return this.http.get<Class[]>("/api/class/all");
  }

  findById(id: any): Observable<any> {
    return this.http.get("/api/class/" + id);
  }

  doSubjectRelation(createSubjectRelationDTO: CreateSubjectRelationDTO) {
    return this.http.post("/api/class/subject-relation", createSubjectRelationDTO);
  }

  report(): Observable<any> {
    return this.http.get<any>("/api/report/class");
  }
  relationsReport(): Observable<any> {
    return this.http.get<any>("/api/report/relations");
  }

}
