import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Class } from 'src/app/model/class';
import { Teacher } from 'src/app/model/teacher';
import { SubjectService } from 'src/app/services/subject.service';
import { ClassService } from '../../../services/class.service';
import { TeacherService } from '../../../services/teacher.service';
import { Subject } from './../../../model/subject';

@Component({
  selector: 'app-create-class',
  templateUrl: './create-class.component.html',
  styleUrls: ['./create-class.component.css']
})
export class CreateClassComponent implements OnInit {

  public class: Class = {
    id: 0,
    name: "",
    academicCategory: "",
    subjectIds: []
  };

  public teachers: Teacher[] = [];
  public isEdit: boolean = false;

  constructor(
    private classService: ClassService,
    private teacherService: TeacherService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.teacherService.listNoManaging().subscribe(teachers => {
      this.teachers = teachers;
    });

    this.route.paramMap.subscribe(params => {
      if (params.get('id') != null) {
        this.isEdit = true
        this.classService.findById(params.get('id')).subscribe(aClass => {
          this.class.id = aClass.id;
          this.class.name = aClass.name;
          this.class.academicCategory = aClass.academicCategory;
          this.class.subjectIds = aClass.subjectIds;

          if (aClass.teacherManagerId != null) {
            this.teacherService.findById(aClass.teacherManagerId).subscribe(teacher => {
              this.teachers.push(teacher);
            })

            this.class.teacherManagerId = aClass.teacherManagerId;
            this.class.teacherManagerName = aClass.teacherManagerName;
          }
        });
      }
    });

  }

  create() {
    this.classService.create(this.class).subscribe(sucess => {
      this.router.navigateByUrl("/list-classes")
    });
  }

  edit() {
    this.classService.edit(this.class).subscribe(sucess => {
      this.router.navigateByUrl("/list-classes")
    });
  }
}
