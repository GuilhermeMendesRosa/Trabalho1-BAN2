package br.udesc.SchoolManagerAPI.domain.teacher.dto;

import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListTeacherDTO {

    private Long id;
    private String name;
    private List<Long> subjectIds;
    private String className;

    public ListTeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();

        List<Subject> subjects = teacher.getSubjects();
        if (subjects != null && !subjects.isEmpty()) {
            this.subjectIds = subjects.stream().map(subject -> subject.getId()).toList();
        }

        if (teacher.getManagedClass() != null) {
            this.className = teacher.getManagedClass().getName();
        }
    }

}
