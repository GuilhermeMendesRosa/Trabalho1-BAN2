import { Component, OnInit } from '@angular/core';
import { ClassService } from 'src/app/services/class.service';
import { StudentService } from 'src/app/services/student.service';
import { TeacherService } from 'src/app/services/teacher.service';
import { ReportService } from './../../../services/report.service';

@Component({
  selector: 'app-reports-menu',
  templateUrl: './reports-menu.component.html',
  styleUrls: ['./reports-menu.component.css']
})
export class ReportsMenuComponent implements OnInit {

  constructor(
    private reportService: ReportService,
    private studentService: StudentService,
    private teacherService: TeacherService,
    private classService: ClassService,
  ) { }

  ngOnInit(): void {
  }

  generateStudentClassSubjectInfo() {
    this.studentService.getStudentClassSubjectInfoReport().subscribe(content => {
      const filename = 'report.txt';
      this.reportService.createTxtFile(content['report'], filename);
    })
  }

  generateNotEnrolledStudentsReport() {
    this.studentService.getNotEnrolledStudentsReport().subscribe(content => {
      const filename = 'report.txt';
      this.reportService.createTxtFile(content['report'], filename);
    })
  }

  generateTeacherReport() {
    this.teacherService.report().subscribe(content => {
      const filename = 'report.txt';
      this.reportService.createTxtFile(content['report'], filename);
    })
  }

  generateClassReport() {
    this.classService.report().subscribe(content => {
      const filename = 'report.txt';
      this.reportService.createTxtFile(content['report'], filename);
    })
  }

}
