import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../../../services/subject.service";
import {Subject} from "../../../model/subject";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-subjects',
  templateUrl: './list-subjects.component.html',
  styleUrls: ['./list-subjects.component.css']
})
export class ListSubjectsComponent implements OnInit {
  public subjects: Subject[] = [];

  constructor(
    private router: Router,
    private subjectService: SubjectService
  ) {
  }

  ngOnInit(): void {
    this.subjectService.list().subscribe(subjects => {
      this.subjects = subjects;
    })
  }

  delete(subjectId: number) {
    this.subjectService.delete(subjectId).subscribe(() => {
        this.ngOnInit();
      },
      (error) => {
        alert('Erro ao excluir matéria');
      }
    )
  }

}
