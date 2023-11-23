package br.udesc.SchoolManagerAPI.controller;

import br.udesc.SchoolManagerAPI.domain.subject.SubjectService;
import br.udesc.SchoolManagerAPI.domain.subject.dto.CreateSubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity create(@RequestBody CreateSubjectDTO subjectDTO) {
        subjectService.save(subjectDTO.getName());

        return ResponseEntity.ok(null);
    }
}
