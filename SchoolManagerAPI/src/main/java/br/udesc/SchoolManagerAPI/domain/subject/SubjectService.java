package br.udesc.SchoolManagerAPI.domain.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public void save(String name) {
        Subject subject = new Subject();
        subject.setName(name);
        subjectRepository.createSubject(subject.getName());
    }

    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}
