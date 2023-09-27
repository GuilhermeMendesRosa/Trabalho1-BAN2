import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListTeacher } from 'src/app/model/listTeacher';
import { TeacherService } from 'src/app/services/teacher.service';

@Component({
  selector: 'app-list-teachers',
  templateUrl: './list-teachers.component.html',
  styleUrls: ['./list-teachers.component.css']
})
export class ListTeachersComponent implements OnInit {

  public teachers: ListTeacher[] = [];

  constructor(
    private teacherService: TeacherService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.teacherService.listAll().subscribe(teachers => {
      this.teachers = teachers;
    })
  }

  edit(id: number) {
    this.router.navigateByUrl("/edit-teacher/" + id);
  }

  delete(id: number) {
    this.teacherService.delete(id).subscribe(() => {
      this.ngOnInit();
    },
      (error) => {
        alert('Erro ao excluir a turma:' + error);
      }
    );
  }

}
