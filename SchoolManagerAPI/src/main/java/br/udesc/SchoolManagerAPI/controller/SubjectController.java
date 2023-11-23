package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.subject.SubjectRepository;
import br.udesc.SchoolManagerAPI.domain.subject.SubjectService;
import br.udesc.SchoolManagerAPI.domain.subject.dto.CreateSubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody CreateSubjectDTO subjectDTO) {
        subjectService.save(subjectDTO.getName());

        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> subjectList = subjectRepository.findAll();

        return ResponseEntity.ok(subjectList);
    }
}
