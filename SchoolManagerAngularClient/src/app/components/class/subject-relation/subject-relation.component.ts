import {Component, OnInit} from '@angular/core';
import {TeacherService} from "../../../services/teacher.service";
import {ListTeacher} from "../../../model/listTeacher";
import {ClassService} from "../../../services/class.service";
import {Class} from "../../../model/class";
import {Subject} from "../../../model/subject";
import {SubjectService} from "../../../services/subject.service";
import {SubjectTeacherRelationDTO} from "../../../model/SubjectTeacherRelationDTO";
import {CreateSubjectRelationDTO} from "../../../model/CreateSubjectRelationDTO";

@Component({
  selector: 'app-subject-relation',
  templateUrl: './subject-relation.component.html',
  styleUrls: ['./subject-relation.component.css']
})
export class SubjectRelationComponent implements OnInit {

  public teachers: ListTeacher[] = [];
  public subjects: Subject[] = [];
  public classes: Class[] = [];
  public mapSubjectTeachers: Map<string, ListTeacher[]> = new Map();

  public selectedClass: number = 0;
  public subjectTeacherRelationDTOs: SubjectTeacherRelationDTO[] = [];


  constructor(
    private teacherService: TeacherService,
    private classService: ClassService,
    private subjectService: SubjectService
  ) {
  }

  ngOnInit(): void {
    this.subjectService.list().subscribe(subjects => {
      this.subjects = subjects;
    })
    this.classService.listAll().subscribe(classes => {
      this.classes = classes;
    });
    this.teacherService.listAll().subscribe(teachers => {
      this.teachers = teachers;
      teachers.forEach(teacher => {
        teacher.subjects?.forEach(subject => {
          if (this.mapSubjectTeachers.get(subject.id.toString())) {
            this.mapSubjectTeachers.get(subject.id.toString())?.push(teacher);
          } else {
            this.mapSubjectTeachers.set(subject.id.toString(), []);
            this.mapSubjectTeachers.get(subject.id.toString())?.push(teacher);
          }
        })
      });

    });
  }

  public addSubject(): void {
    this.subjectTeacherRelationDTOs.push({subjectId: "", teacherId: ""});
  }

  public createSubjectRelation(): void {
    let createSubjectRelationDTO:CreateSubjectRelationDTO = {
      classId: this.selectedClass,
      subjectTeacherRelationList: [...this.subjectTeacherRelationDTOs]
    }
    this.classService.doSubjectRelation(createSubjectRelationDTO).subscribe();
  }

}
