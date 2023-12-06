import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../../../services/subject.service";
import {Subject} from "../../../model/subject";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-subject',
  templateUrl: './create-subject.component.html',
  styleUrls: ['./create-subject.component.css']
})
export class CreateSubjectComponent implements OnInit {

  public subject: Subject = {id: 0, name: ""};

  constructor(
    private router: Router,
    private subjectService: SubjectService
  ) {
  }

  ngOnInit(): void {
  }

  create() {
    this.subjectService.create(this.subject).subscribe(() => {
        this.router.navigateByUrl("/list-subjects")
      },
      (error) => {
        console.error('Erro ao remover a matéria:', error);
      });
  }

}
