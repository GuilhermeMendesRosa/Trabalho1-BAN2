package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.classes.ClassService;
import br.udesc.SchoolManagerAPI.domain.classes.dto.ClassDTO;
import br.udesc.SchoolManagerAPI.domain.subjectRelation.dto.CreateSubjectRelationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity create(@RequestBody ClassDTO classDTO) {
        this.classService.create(classDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(this.classService.findAll());
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.classService.findById(id));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            this.classService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity edit(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
        try {
            this.classService.edit(id, classDTO);

            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/subject-relation")
    @Transactional
    public ResponseEntity doSubjectRelation(@RequestBody CreateSubjectRelationDTO createSubjectRelationDTO) {
        this.classService.doSubjectRelation(createSubjectRelationDTO);
        return ResponseEntity.ok().build();
    }

}
