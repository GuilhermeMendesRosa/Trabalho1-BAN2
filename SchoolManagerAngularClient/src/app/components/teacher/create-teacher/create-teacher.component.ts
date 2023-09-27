import { TeacherService } from '../../../services/teacher.service';
import { Subject } from '../../../model/subject';
import { SubjectService } from '../../../services/subject.service';
import { Component, OnInit } from '@angular/core';
import { Teacher } from 'src/app/model/teacher';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-teacher',
  templateUrl: './create-teacher.component.html',
  styleUrls: ['./create-teacher.component.css']
})
export class CreateTeacherComponent implements OnInit {

  public teacher: Teacher = { id: 0, name: "" };
  public subjects: Subject[] = [];
  public isEdit: boolean = false;

  constructor(
    private subjectService: SubjectService,
    private teacherService: TeacherService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.subjectService.list().subscribe(subjects => {
      this.subjects = subjects
    })

    this.route.paramMap.subscribe(params => {
      if (params.get('id') != null) {
        this.isEdit = true
        this.teacherService.findById(params.get('id')).subscribe(teacher => {
          this.teacher.id = teacher.id;
          this.teacher.name = teacher.name;
          this.teacher.subjectIds = teacher.subjectIds;
        })
      }
    });
  }

  create() {
    this.teacherService.create(this.teacher).subscribe(sucess => {
      this.router.navigateByUrl("/list-teachers")
    });
  }

  edit() {
    this.teacherService.edit(this.teacher).subscribe(sucess => {
      this.router.navigateByUrl("/list-teachers")
    });
  }
}
