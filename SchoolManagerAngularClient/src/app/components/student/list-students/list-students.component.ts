import { Component, OnInit } from '@angular/core';
import { ListStudent } from 'src/app/model/listStudent';
import { StudentService } from '../../../services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-students',
  templateUrl: './list-students.component.html',
  styleUrls: ['./list-students.component.css']
})
export class ListStudentsComponent implements OnInit {

  public students: ListStudent[] = [];

  constructor(
    private studentService: StudentService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.studentService.findAll().subscribe(students => {
      this.students = students;
    })
  }

  edit(id: number) {
    this.router.navigateByUrl("/edit-student/" + id);
  }

  delete(id: number) {
    this.studentService.delete(id).subscribe(() => {
      this.ngOnInit();
    },
      (error) => {
        alert('Erro ao excluir aluno:');
      }
    );
  }

}
