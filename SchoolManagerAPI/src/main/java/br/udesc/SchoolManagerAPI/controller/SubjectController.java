package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.subject.SubjectRepository;
import br.udesc.SchoolManagerAPI.domain.subject.SubjectService;
import br.udesc.SchoolManagerAPI.domain.subject.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> all = subjectRepository.findAll();

        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SubjectDTO subjectDTO) {
        subjectService.save(subjectDTO.getName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        subjectService.delete(id);
        return ResponseEntity.ok().build();
    }

}
