package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.classes.ClassService;
import br.udesc.SchoolManagerAPI.domain.classes.dto.ClassDTO;
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
        return ResponseEntity.ok(this.classService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.classService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        this.classService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity edit(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
        this.classService.edit(id, classDTO);
        return ResponseEntity.ok().build();
    }

}
