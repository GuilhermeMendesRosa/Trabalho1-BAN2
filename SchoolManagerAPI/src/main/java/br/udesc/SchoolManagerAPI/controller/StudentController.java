package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.student.StudentService;
import br.udesc.SchoolManagerAPI.domain.student.dto.CreateStudentDTO;
import br.udesc.SchoolManagerAPI.domain.student.dto.ListStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("list")
    public ResponseEntity findAll() {
        List<ListStudentDTO> listStudentDTOS = this.studentService.listStudents();

        return ResponseEntity.ok(listStudentDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        ListStudentDTO listStudentDTOS = this.studentService.findById(id);

        return ResponseEntity.ok(listStudentDTOS);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateStudentDTO createStudentDTO) {
        this.studentService.create(createStudentDTO);

        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity edit(@PathVariable Long id, @RequestBody CreateStudentDTO createStudentDTO) {
        this.studentService.edit(id, createStudentDTO);
        return ResponseEntity.ok().build();
    }

}
