import { Component, OnInit } from '@angular/core';
import { Class } from 'src/app/model/class';
import { ClassService } from '../../../services/class.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-classes',
  templateUrl: './list-classes.component.html',
  styleUrls: ['./list-classes.component.css']
})
export class ListClassesComponent implements OnInit {

  public classes: Class[] = [];
  public literals: any = {
    'High_School': 'Ensino Médio',
    'Elementary_School': 'Ensino Fundamental'
  }

  constructor(
    private classService: ClassService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.classService.listAll().subscribe(classes => {
      this.classes = classes;
    })
  }

  edit(id: number) {
    this.router.navigateByUrl("/edit-class/" + id);
  }

  delete(id: number) {
    this.classService.delete(id).subscribe(() => {
      this.ngOnInit();
    },
      (error) => {
        alert('Erro ao excluir a turma');
      }
    );
  }


}
