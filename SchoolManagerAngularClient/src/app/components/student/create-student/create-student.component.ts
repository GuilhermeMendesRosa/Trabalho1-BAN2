import { Component, OnInit } from '@angular/core';
import { Class } from 'src/app/model/class';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/services/student.service';
import { ClassService } from '../../../services/class.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  public classes: Class[] = [];
  public student: Student = {}
  public isEdit: boolean = false;

  constructor(
    private classService: ClassService,
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.classService.listAll().subscribe(classes => {
      this.classes = classes;
    })

    this.route.paramMap.subscribe(params => {
      if (params.get('id') != null) {
        this.isEdit = true;

        this.studentService.findById(params.get('id')).subscribe(student => {
          this.student.id = student.id;
          this.student.name = student.name;

          if (student.classId != null) {
            this.student.classId = student.classId;
            this.student.className = student.className;
          }
        })
      }
    });
  }

  create() {
    this.studentService.create(this.student).subscribe(sucess => {
      this.router.navigateByUrl("/list-students")
    });
  }

  edit() {
    this.studentService.edit(this.student).subscribe(sucess => {
      this.router.navigateByUrl("/list-students")
    });
  }

}
