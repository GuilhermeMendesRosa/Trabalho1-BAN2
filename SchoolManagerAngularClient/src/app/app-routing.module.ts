import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClassesMenuComponent } from './components/class/classes-menu/classes-menu.component';
import { CreateClassComponent } from './components/class/create-class/create-class.component';
import { ListClassesComponent } from './components/class/list-classes/list-classes.component';
import { MenuComponent } from './components/menu/menu.component';
import { ReportsMenuComponent } from './components/report/reports-menu/reports-menu.component';
import { CreateStudentComponent } from './components/student/create-student/create-student.component';
import { ListStudentsComponent } from './components/student/list-students/list-students.component';
import { StudentsMenuComponent } from './components/student/students-menu/students-menu.component';
import { CreateTeacherComponent } from './components/teacher/create-teacher/create-teacher.component';
import { ListTeachersComponent } from './components/teacher/list-teachers/list-teachers.component';
import { TeachersMenuComponent } from './components/teacher/teachers-menu/teachers-menu.component';

const routes: Routes = [
  {
    path: "",
    component: MenuComponent
  },
  {
    path: "students",
    component: StudentsMenuComponent
  },
  {
    path: "teachers",
    component: TeachersMenuComponent
  },
  {
    path: "classes",
    component: ClassesMenuComponent
  },
  {
    path: "reports",
    component: ReportsMenuComponent
  },
  {
    path: "create-class",
    component: CreateClassComponent
  },
  {
    path: "edit-class/:id",
    component: CreateClassComponent
  },
  {
    path: "create-student",
    component: CreateStudentComponent
  },
  {
    path: "edit-student/:id",
    component: CreateStudentComponent
  },
  {
    path: "create-teacher",
    component: CreateTeacherComponent
  },
  {
    path: "edit-teacher/:id",
    component: CreateTeacherComponent
  },
  {
    path: "list-classes",
    component: ListClassesComponent
  },
  {
    path: "list-students",
    component: ListStudentsComponent
  },
  {
    path: "list-teachers",
    component: ListTeachersComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
