package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.classes.ClassService;
import br.udesc.SchoolManagerAPI.domain.student.StudentService;
import br.udesc.SchoolManagerAPI.domain.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassService classService;

    @GetMapping("student")
    public ResponseEntity studentReport() {
        try {
            return ResponseEntity.ok(studentService.report());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("teacher")
    public ResponseEntity teacherReport() {
        try {
            return ResponseEntity.ok(teacherService.report());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("class")
    public ResponseEntity classReport() {
        return ResponseEntity.ok(classService.report());
    }

}
