import { HttpClientModule } from '@angular/common/http'; // Importe o HttpClientModule
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTeacherComponent } from './components/teacher/create-teacher/create-teacher.component';
import { CreateStudentComponent } from './components/student/create-student/create-student.component';
import { CreateClassComponent } from './components/class/create-class/create-class.component';
import { MenuComponent } from './components/menu/menu.component';
import { StudentsMenuComponent } from './components/student/students-menu/students-menu.component';
import { TeachersMenuComponent } from './components/teacher/teachers-menu/teachers-menu.component';
import { ClassesMenuComponent } from './components/class/classes-menu/classes-menu.component';
import { HeaderComponent } from './components/header/header.component';
import { ListStudentsComponent } from './components/student/list-students/list-students.component';
import { ListTeachersComponent } from './components/teacher/list-teachers/list-teachers.component';
import { ListClassesComponent } from './components/class/list-classes/list-classes.component';
import { ReportsMenuComponent } from './components/report/reports-menu/reports-menu.component';
import { SubjectRelationComponent } from './components/class/subject-relation/subject-relation.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateTeacherComponent,
    CreateStudentComponent,
    CreateClassComponent,
    MenuComponent,
    StudentsMenuComponent,
    TeachersMenuComponent,
    ClassesMenuComponent,
    HeaderComponent,
    ListStudentsComponent,
    ListTeachersComponent,
    ListClassesComponent,
    ReportsMenuComponent,
    SubjectRelationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
