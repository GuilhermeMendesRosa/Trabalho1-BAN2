package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        List<Subject> all = subjectRepository.findAll();

        return ResponseEntity.ok(all);
    }

}
