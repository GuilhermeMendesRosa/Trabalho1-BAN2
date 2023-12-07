package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import br.udesc.SchoolManagerAPI.domain.teacher.TeacherService;
import br.udesc.SchoolManagerAPI.domain.teacher.dto.ListTeacherDTO;
import br.udesc.SchoolManagerAPI.domain.teacher.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity create(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = this.teacherService.create(teacherDTO);

        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/no-managing")
    public ResponseEntity findNoManagingTeachers() {
        List<TeacherDTO> noManagingTeachers = this.teacherService.findNoManagingTeachers();
        return ResponseEntity.ok(noManagingTeachers);
    }

    @GetMapping("/list")
    public ResponseEntity listAll() {
        List<ListTeacherDTO> teacherDTOS = this.teacherService.listAll();
        return ResponseEntity.ok(teacherDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        ListTeacherDTO teacher = this.teacherService.findById(id);
        return ResponseEntity.ok(teacher);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.teacherService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity edit(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        this.teacherService.edit(id, teacherDTO);
        return ResponseEntity.ok().build();
    }

}
